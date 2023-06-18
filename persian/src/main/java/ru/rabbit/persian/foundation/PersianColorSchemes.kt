package ru.rabbit.persian.foundation

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import ru.rabbit.persian.foundation.Error10
import ru.rabbit.persian.foundation.Error100
import ru.rabbit.persian.foundation.Error20
import ru.rabbit.persian.foundation.Error30
import ru.rabbit.persian.foundation.Error40
import ru.rabbit.persian.foundation.Error80
import ru.rabbit.persian.foundation.Error90
import ru.rabbit.persian.foundation.Neutral0
import ru.rabbit.persian.foundation.Neutral10
import ru.rabbit.persian.foundation.Neutral20
import ru.rabbit.persian.foundation.Neutral6
import ru.rabbit.persian.foundation.Neutral90
import ru.rabbit.persian.foundation.Neutral95
import ru.rabbit.persian.foundation.Neutral98
import ru.rabbit.persian.foundation.NeutralVariant30
import ru.rabbit.persian.foundation.NeutralVariant50
import ru.rabbit.persian.foundation.NeutralVariant60
import ru.rabbit.persian.foundation.NeutralVariant80
import ru.rabbit.persian.foundation.NeutralVariant90
import ru.rabbit.persian.foundation.Primary10
import ru.rabbit.persian.foundation.Primary100
import ru.rabbit.persian.foundation.Primary20
import ru.rabbit.persian.foundation.Primary30
import ru.rabbit.persian.foundation.Primary40
import ru.rabbit.persian.foundation.Primary80
import ru.rabbit.persian.foundation.Primary90
import ru.rabbit.persian.foundation.Secondary10
import ru.rabbit.persian.foundation.Secondary100
import ru.rabbit.persian.foundation.Secondary20
import ru.rabbit.persian.foundation.Secondary30
import ru.rabbit.persian.foundation.Secondary40
import ru.rabbit.persian.foundation.Secondary80
import ru.rabbit.persian.foundation.Secondary90
import ru.rabbit.persian.foundation.Tertiary10
import ru.rabbit.persian.foundation.Tertiary100
import ru.rabbit.persian.foundation.Tertiary20
import ru.rabbit.persian.foundation.Tertiary30
import ru.rabbit.persian.foundation.Tertiary40
import ru.rabbit.persian.foundation.Tertiary80
import ru.rabbit.persian.foundation.Tertiary90

const val PersianStatesDisabled = .38f

val LightColorScheme = lightColorScheme(
    primary = Primary40,
    primaryContainer = Primary90,
    onPrimary = Primary100,
    onPrimaryContainer = Primary10,
    inversePrimary = Primary80,
    secondary = Secondary40,
    secondaryContainer = Secondary90,
    onSecondary = Secondary100,
    onSecondaryContainer = Secondary10,
    tertiary = Tertiary40,
    tertiaryContainer = Tertiary90,
    onTertiary = Tertiary100,
    onTertiaryContainer = Tertiary10,
    surface = Neutral98,
    surfaceVariant = NeutralVariant90,
    onSurface = Neutral10,
    onSurfaceVariant = NeutralVariant30,
    inverseSurface = Neutral20,
    inverseOnSurface = Neutral95,
    background = Neutral98,
    onBackground = Neutral10,
    error = Error40,
    errorContainer = Error90,
    onError = Error100,
    onErrorContainer = Error10,
    outline = NeutralVariant50,
    outlineVariant = NeutralVariant80,
    scrim = Neutral0,
)

val DarkColorScheme = darkColorScheme(
    primary = Primary80,
    primaryContainer = Primary30,
    onPrimary = Primary20,
    onPrimaryContainer = Primary90,
    inversePrimary = Primary40,
    secondary = Secondary80,
    secondaryContainer = Secondary30,
    onSecondary = Secondary20,
    onSecondaryContainer = Secondary90,
    tertiary = Tertiary80,
    tertiaryContainer = Tertiary30,
    onTertiary = Tertiary20,
    onTertiaryContainer = Tertiary90,
    surface = Neutral6,
    surfaceVariant = NeutralVariant30,
    onSurface = Neutral90,
    onSurfaceVariant = NeutralVariant80,
    inverseSurface = Neutral90,
    inverseOnSurface = Neutral20,
    background = Neutral6,
    onBackground = Neutral90,
    error = Error80,
    errorContainer = Error30,
    onError = Error20,
    onErrorContainer = Error90,
    outline = NeutralVariant60,
    outlineVariant = NeutralVariant30,
    scrim = Neutral0,
)