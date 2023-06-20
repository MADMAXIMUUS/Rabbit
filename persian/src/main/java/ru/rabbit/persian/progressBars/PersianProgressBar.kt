package ru.rabbit.persian.progressBars

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import ru.rabbit.persian.foundation.PersianTheme

object PersianProgressBar {

    @Composable
    fun Circular(
        modifier: Modifier = Modifier,
        colors: ProgressBarColors = PersianProgressBarColors.primary(),
        sizes: CircularProgressBarSizes = PersianCircularProgressBarSize.medium(),
    ) {
        Box(
            modifier = modifier
                .size(size = sizes.boxSize),
        ) {
            CircularProgressIndicator(
                progress = 0.5f,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize()
                    .padding(sizes.contentPadding),
                color = colors.progressColor,
                trackColor = colors.backgroundColor,
                strokeCap = StrokeCap.Round,
                strokeWidth = sizes.strokeSize
            )
        }
    }
}


@Preview
@Composable
fun ProgressBarPreview() {
    PersianTheme {
        Surface {
            PersianProgressBar.Circular(
                sizes = PersianCircularProgressBarSize.small()
            )
        }
    }
}