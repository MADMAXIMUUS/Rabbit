package ru.madmax.composetwitterclone.feature.registry.ui.setProfilePicture

import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collectLatest
import ru.madmax.composetwitterclone.core.ui.R
import ru.madmax.composetwitterclone.core.ui.components.TButton
import ru.madmax.composetwitterclone.core.ui.components.TOutlineButton
import ru.madmax.composetwitterclone.core.ui.components.TTextButton
import ru.madmax.composetwitterclone.core.ui.components.TTopAppBar
import ru.madmax.composetwitterclone.core.ui.components.dashedBorder
import ru.madmax.composetwitterclone.core.ui.components.dialogs.CropImageDialog
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.CONFIRM_SIGN_UP_SCREEN
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.SET_PROFILE_IMAGE_SCREEN
import ru.madmax.composetwitterclone.feature.registry.navigation.Routes.WELCOME_SCREEN
import ru.madmax.composetwitterclone.util.FileUtils
import ru.madmax.composetwitterclone.util.TwitterCloneFileProvider
import ru.madmax.composetwitterclone.util.UiAction
import ru.madmax.composetwitterclone.util.asString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetProfileImageScreen(
    navController: NavController,
    snackbarHostState: SnackbarHostState,
    viewModel: SetPicturePictureViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    val context = LocalContext.current

    var imageUri by remember { mutableStateOf<Uri?>(null) }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {

                is UiAction.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message.asString(context),
                        duration = SnackbarDuration.Long
                    )
                }

                is UiAction.Navigate -> {
                    navController.navigate(event.route) {
                        popUpTo(SET_PROFILE_IMAGE_SCREEN) {
                            inclusive = true
                        }
                    }
                }

                else -> {}
            }
        }
    }

    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    ImageDecoder.decodeBitmap(
                        ImageDecoder.createSource(
                            context.contentResolver, it
                        )
                    )
                } else {
                    @Suppress("DEPRECATION")
                    MediaStore.Images.Media.getBitmap(context.contentResolver, it)
                }
                viewModel.setPhoto(bitmap)
            }
        }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            if (success) {
                imageUri?.let {
                    val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        ImageDecoder.decodeBitmap(
                            ImageDecoder.createSource(
                                context.contentResolver, it
                            )
                        )
                    } else {
                        @Suppress("DEPRECATION")
                        MediaStore.Images.Media.getBitmap(context.contentResolver, it)
                    }
                    viewModel.setPhoto(bitmap)
                }
            }
        }
    )

    if (state.isNeedTypeDialog) {
        AlertDialog(
            modifier = Modifier.padding(horizontal = 20.dp),
            onDismissRequest = {
                viewModel.hideDialog()
            }, properties = DialogProperties(
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = false
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TTextButton(modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            viewModel.hideDialog()
                            val uri = TwitterCloneFileProvider.getImageUri(context)
                            imageUri = uri
                            cameraLauncher.launch(uri)
                        }
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Take photo",
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Start
                        )
                    }
                    TTextButton(modifier = Modifier.fillMaxWidth(), onClick = {
                        galleryLauncher.launch("image/*")
                        viewModel.hideDialog()
                    }) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Choose exciting photo",
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }
        }
    }

    if (state.isNeedCropDialog) {
        CropImageDialog(
            image = state.photo,
            imageWidth = state.photoWidth,
            imageHeight = state.photoHeight
        ) {
            viewModel.setCroppedPhoto(it)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        TTopAppBar(title = {
            Icon(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.app_logo),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = ""
            )
        })
        Spacer(modifier = Modifier.weight(0.05f))
        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.set_profile_picture_title),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.padding(horizontal = 40.dp),
            text = stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.set_profile_picture_hint),
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.weight(0.1f))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(0.5f))
            if (state.croppedPhoto == null) {
                IconButton(
                    modifier = Modifier
                        .size(200.dp)
                        .dashedBorder(4.dp, MaterialTheme.colorScheme.primary, 30.dp), onClick = {
                        viewModel.showDialog()
                    }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(70.dp),
                            painter = painterResource(id = ru.madmax.composetwitterclone.feature.registry.R.drawable.ic_camera),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.upload),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            } else {
                IconButton(
                    modifier = Modifier
                        .size(200.dp)
                        .border(2.dp, MaterialTheme.colorScheme.onBackground, shape = CircleShape)
                        .clipToBounds(),
                    onClick = {
                        viewModel.showDialog()
                    }
                ) {
                    Image(
                        bitmap = state.croppedPhoto!!.asImageBitmap(),
                        contentScale = ContentScale.Fit,
                        contentDescription = ""
                    )
                }
            }
            Spacer(modifier = Modifier.weight(0.5f))
        }
        Spacer(modifier = Modifier.weight(0.5f))
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                TOutlineButton(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.secondary
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = {
                        viewModel.skip()
                    }
                ) {
                    Text(stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.skip_button_label))
                }
                Spacer(modifier = Modifier.weight(0.1f))
                TButton(enabled = state.isButtonEnabled,
                    modifier = Modifier.padding(end = 10.dp),
                    onClick = {
                        val file = state
                            .croppedPhoto?.let { FileUtils.bitmapToFile(it) }
                        file?.let { viewModel.next(it) }
                    },
                    contentPadding = if (state.isLoading) PaddingValues(
                        horizontal = 34.dp
                    ) else
                        ButtonDefaults.ContentPadding
                ) {
                    if (state.isLoading) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .size(20.dp),
                            strokeWidth = 3.dp,
                            strokeCap = StrokeCap.Round
                        )
                    } else {
                        Text(
                            text = stringResource(ru.madmax.composetwitterclone.feature.registry.R.string.next_button_label)
                        )
                    }
                }
            }
        }

    }
}