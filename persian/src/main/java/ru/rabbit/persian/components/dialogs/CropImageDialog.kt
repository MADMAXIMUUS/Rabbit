package ru.rabbit.persian.components.dialogs

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import ru.rabbit.persian.components.TTopAppBar
import ru.rabbit.persian.foundation.icons
import kotlin.math.abs
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CropImageDialog(
    image: Bitmap,
    imageWidth: Int,
    imageHeight: Int,
    onDismissRequest: (Bitmap?) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth =
        with(LocalDensity.current) { configuration.screenWidthDp.dp.roundToPx() - 150f }
    val background = MaterialTheme.colorScheme.background
    val onBackground = MaterialTheme.colorScheme.onBackground
    var outBitmap: Bitmap? = null
    val preScale = if (imageWidth < imageHeight) screenWidth / imageWidth
    else screenWidth / imageHeight

    val newImageWidth = (imageWidth * preScale).roundToInt()
    val newImageHeight = (imageHeight * preScale).roundToInt()

    val scaledBitmap = Bitmap
        .createScaledBitmap(
            image,
            newImageWidth,
            newImageHeight,
            true
        )!!

    var zoom by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    Dialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = false,
        ),
        onDismissRequest = {
            onDismissRequest(outBitmap)
        }
    ) {
        val dialogWindowProvider = (LocalView.current.parent as DialogWindowProvider)
        dialogWindowProvider.window.setDimAmount(0f)
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                TTopAppBar(
                    title = { Text("Move and scale") },
                    navigationIcon = MaterialTheme.icons.close,
                    navigationIconContentDescription = "",
                    onNavigationClick = {
                        onDismissRequest(outBitmap)
                    },
                    actionText = "Apply",
                    onActionClick = {
                        val x =
                            (((newImageWidth * zoom / 2f - screenWidth / 2f) - offset.x) / zoom)
                                .roundToInt()
                        val y =
                            (((newImageHeight * zoom / 2f - screenWidth / 2f) - offset.y) / zoom)
                                .roundToInt()

                        val sizeX = (screenWidth / zoom).roundToInt()
                        val sizeY = (screenWidth / zoom).roundToInt()

                        try {
                            outBitmap = Bitmap.createBitmap(scaledBitmap, x, y, sizeX, sizeY)
                            outBitmap = Bitmap.createScaledBitmap(
                                outBitmap!!,
                                (sizeX * zoom).toInt(),
                                (sizeY * zoom).toInt(),
                                true
                            )
                        } catch (e: IllegalArgumentException) {
                            e.localizedMessage?.let { Log.e("Cropped Error", it) }
                        }
                        onDismissRequest(outBitmap)
                    }
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .drawWithContent {
                            drawContent()
                            val circlePath = Path().apply {
                                addOval(Rect(center, screenWidth / 2f))
                            }
                            clipPath(circlePath, clipOp = ClipOp.Difference) {
                                drawRect(
                                    color = background.copy(alpha = 0.8f),
                                )
                            }
                            drawCircle(
                                color = onBackground,
                                center = center,
                                radius = screenWidth / 2f,
                                style = Stroke(width = 5f)
                            )
                        }
                        .clipToBounds(),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(
                        modifier = Modifier
                            .pointerInput(Unit) {
                                detectTransformGestures(
                                    onGesture = { _, gesturePan, gestureZoom, _ ->
                                        val newScale = (zoom * gestureZoom).coerceAtLeast(1f)
                                        val newOffset = offset + gesturePan
                                        zoom = newScale

                                        val maxX =
                                            abs((screenWidth - newImageWidth * zoom) / 2f)
                                        val maxY =
                                            abs((screenWidth - newImageHeight * zoom) / 2f)

                                        offset = Offset(
                                            newOffset.x.coerceIn(-maxX, maxX),
                                            newOffset.y.coerceIn(-maxY, maxY)
                                        )
                                    }
                                )
                            }
                            .fillMaxSize()
                    ) {
                        val canvasWidth = size.width
                        val canvasHeight = size.height
                        translate(left = offset.x, top = offset.y) {
                            scale(scaleX = zoom, scaleY = zoom) {
                                drawImage(
                                    image = scaledBitmap.asImageBitmap(),
                                    topLeft = Offset(
                                        x = (canvasWidth - newImageWidth) / 2f,
                                        y = (canvasHeight - newImageHeight) / 2f
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
