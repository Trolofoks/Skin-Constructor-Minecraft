package com.honey.skinconstructorminecraft.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = OldGreen80,
    onPrimary = OldGreen20,
    primaryContainer = OldGreen30,
    onPrimaryContainer = OldGreen90,

    secondary = Orange80,
    onSecondary = Orange20,
    secondaryContainer = Orange30,
    onSecondaryContainer = Orange90,

    tertiary = Purple80,
    onTertiary = Purple20,
    tertiaryContainer = Purple30,
    onTertiaryContainer = Purple90,

    error = Red80,
    onError = Red20,
    errorContainer = Red30,

    background = DarkGreenGray10,
    onBackground = DarkGreenGray90,

    surface = DarkGreenGray10,
    onSurface = DarkGreenGray90

)

private val LightColorScheme = lightColorScheme(
    primary = OldGreen40,
    onPrimary = OldGreen80,
    primaryContainer = OldGreen90,
    onPrimaryContainer = OldGreen20,

    secondary = Orange40,
    onSecondary = Orange80,
    secondaryContainer = Orange90,
    onSecondaryContainer = Orange20,

    tertiary = Purple40,
    onTertiary = Purple80,
    tertiaryContainer = Purple90,
    onTertiaryContainer = Purple20,

    error = Red40,
    onError = Red90,
    errorContainer = Red80,

    background = DarkGreenGray90,
    onBackground = DarkGreenGray10,

    surface = DarkGreenGray90,
    onSurface = DarkGreenGray10

)

@Composable
fun ScmcTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primaryContainer.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}