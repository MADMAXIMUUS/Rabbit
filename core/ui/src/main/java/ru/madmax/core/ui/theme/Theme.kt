package ru.madmax.core.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    onPrimary = Blue20,
    primaryContainer = Blue30,
    onPrimaryContainer = Blue90,
    inversePrimary = Blue40,
    secondary = BluePurple80,
    onSecondary = BluePurple20,
    secondaryContainer = BluePurple30,
    onSecondaryContainer = BluePurple90,
    tertiary = BlueViolet80,
    onTertiary = BlueViolet20,
    tertiaryContainer = BlueViolet30,
    onTertiaryContainer = BlueViolet90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Grey10,
    onBackground = Grey90,
    surface = Grey10,
    onSurface = Grey90,
    inverseSurface = BlueViolet90,
    inverseOnSurface = Grey10,
    surfaceVariant = GreyVariant30,
    onSurfaceVariant = GreyVariant80,
    outline = GreyVariant60,
)

private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    onPrimary = Color.White,
    primaryContainer = Blue90,
    onPrimaryContainer = Blue10,
    inversePrimary = Blue80,
    secondary = BluePurple40,
    onSecondary = Color.White,
    secondaryContainer = BluePurple90,
    onSecondaryContainer = BluePurple10,
    tertiary = BlueViolet40,
    onTertiary = Color.White,
    tertiaryContainer = BlueViolet90,
    onTertiaryContainer = BlueViolet10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Grey99,
    onBackground = Grey10,
    surface = Grey99,
    onSurface = Grey10,
    inverseSurface = Grey10,
    inverseOnSurface = Grey99,
    surfaceVariant = GreyVariant90,
    onSurfaceVariant = GreyVariant30,
    outline = GreyVariant50,
)

@Composable
fun ComposeTwitterCloneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        val currentWindow = (view.context as? Activity)?.window
            ?: throw Exception("Not in an activity - unable to get Window reference")
        SideEffect {
            currentWindow.statusBarColor = Color.Transparent.toArgb()
            currentWindow.navigationBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(currentWindow, view).isAppearanceLightStatusBars =
                !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = Shapes
    )
}