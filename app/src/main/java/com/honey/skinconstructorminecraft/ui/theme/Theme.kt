package com.honey.skinconstructorminecraft.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = Green80,
    onPrimary = Green20,
    primaryContainer = Green30,
    onPrimaryContainer = Green90,

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
    primary = Green40,
    onPrimary = Green80,
    primaryContainer = Green90,
    onPrimaryContainer = Green20,

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
fun SkinConstructorMinecraftTheme(
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
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}