package com.daoflowers.android.ui.theme

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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat

// Material 3 color schemes
private val darkColorScheme = darkColorScheme(
    primary = dark_primary,
    onPrimary = dark_onPrimary,
    primaryContainer = dark_primaryContainer,
    onPrimaryContainer = dark_onPrimaryContainer,
    inversePrimary = dark_inversePrimary,
    secondary = dark_secondary,
    onSecondary = dark_onSecondary,
    secondaryContainer = dark_secondaryContainer,
    onSecondaryContainer = dark_onSecondaryContainer,
    tertiary = dark_tertiary,
    onTertiary = dark_onTertiary,
    tertiaryContainer = dark_tertiaryContainer,
    onTertiaryContainer = dark_onTertiaryContainer,
    error = dark_error,
    onError = dark_onError,
    errorContainer = dark_errorContainer,
    onErrorContainer = dark_onErrorContainer,
    background = dark_background,
    onBackground = dark_onBackground,
    surface = dark_surface,
    onSurface = dark_onSurface,
    inverseSurface = dark_inverseSurface,
    inverseOnSurface = dark_inverseOnSurface,
    surfaceVariant = dark_surfaceVariant,
    onSurfaceVariant = dark_onSurfaceVariant,
    outline = dark_outline,
    surfaceTint = dark_surfaceTint,
    outlineVariant = dark_outlineVariant,
    scrim = dark_scrim,
)

private val lightColorScheme = lightColorScheme(
    primary = light_primary,
    onPrimary = light_onPrimary,
    primaryContainer = light_primaryContainer,
    onPrimaryContainer = light_onPrimaryContainer,
    inversePrimary = light_inversePrimary,
    secondary = light_secondary,
    onSecondary = light_onSecondary,
    secondaryContainer = light_secondaryContainer,
    onSecondaryContainer = light_onSecondaryContainer,
    tertiary = light_tertiary,
    onTertiary = light_onTertiary,
    tertiaryContainer = light_tertiaryContainer,
    onTertiaryContainer = light_onTertiaryContainer,
    error = light_error,
    onError = light_onError,
    errorContainer = light_errorContainer,
    onErrorContainer = light_onErrorContainer,
    background = light_background,
    onBackground = light_onBackground,
    surface = light_surface,
    onSurface = light_onSurface,
    inverseSurface = light_inverseSurface,
    inverseOnSurface = light_inverseOnSurface,
    surfaceVariant = light_surfaceVariant,
    onSurfaceVariant = light_onSurfaceVariant,
    outline = light_outline,
    surfaceTint = light_surfaceTint,
    outlineVariant = light_outlineVariant,
    scrim = light_scrim,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    // Set the status bar color
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            // set the status bar color and light / dark icons color
            (view.context as Activity).window.statusBarColor = colorScheme.surface.toArgb()
            WindowCompat
                .getInsetsController((view.context as Activity).window, view)
                .isAppearanceLightStatusBars = darkTheme.not()
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = replyTypography,
        content = content
    )
}