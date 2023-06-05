package com.daoflowers.android.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val light_primary = Color(0xFF2F80ED)
val light_onPrimary = Color(0xFFFFFFFF)
val light_primaryContainer = Color(0xFFD7E3FF)
val light_onPrimaryContainer = Color(0xFF001B3F)
val light_secondary = Color(0xFF5738F2)
val light_onSecondary = Color(0xFFFFFFFF)
val light_secondaryContainer = Color(0xFFE4DFFF)
val light_onSecondaryContainer = Color(0xFF170065)
val light_tertiary = Color(0xFF3E5AA9)
val light_onTertiary = Color(0xFFFFFFFF)
val light_tertiaryContainer = Color(0xFFDBE1FF)
val light_onTertiaryContainer = Color(0xFF00174B)
val light_error = Color(0xFFBA1A1A)
val light_errorContainer = Color(0xFFFFDAD6)
val light_onError = Color(0xFFFFFFFF)
val light_onErrorContainer = Color(0xFF410002)
val light_background = Color(0xFFFFFFFF)
val light_onBackground = Color(0xFF001F2A)
val light_surface = Color(0xFFFFFFFF)
val light_onSurface = Color(0xFF001F2A)
val light_surfaceVariant = Color(0xFFE0E2EC)
val light_onSurfaceVariant = Color(0xFF44474E)
val light_outline = Color(0xFF74777F)
val light_inverseOnSurface = Color(0xFFE1F4FF)
val light_inverseSurface = Color(0xFF003547)
val light_inversePrimary = Color(0xFFABC7FF)
val light_shadow = Color(0xFF000000)
val light_surfaceTint = Color(0xFF005CBA)
val light_outlineVariant = Color(0xFFC4C6D0)
val light_scrim = Color(0xFF000000)

val dark_primary = Color(0xFFABC7FF)
val dark_onPrimary = Color(0xFF002F65)
val dark_primaryContainer = Color(0xFF00458E)
val dark_onPrimaryContainer = Color(0xFFD7E3FF)
val dark_secondary = Color(0xFFC7BFFF)
val dark_onSecondary = Color(0xFF2A009F)
val dark_secondaryContainer = Color(0xFF3E03DC)
val dark_onSecondaryContainer = Color(0xFFE4DFFF)
val dark_tertiary = Color(0xFFB4C5FF)
val dark_onTertiary = Color(0xFF002A78)
val dark_tertiaryContainer = Color(0xFF244290)
val dark_onTertiaryContainer = Color(0xFFDBE1FF)
val dark_error = Color(0xFFFFB4AB)
val dark_errorContainer = Color(0xFF93000A)
val dark_onError = Color(0xFF690005)
val dark_onErrorContainer = Color(0xFFFFDAD6)
val dark_background = Color(0xFF001F2A)
val dark_onBackground = Color(0xFFBFE9FF)
val dark_surface = Color(0xFF001F2A)
val dark_onSurface = Color(0xFFBFE9FF)
val dark_surfaceVariant = Color(0xFF44474E)
val dark_onSurfaceVariant = Color(0xFFC4C6D0)
val dark_outline = Color(0xFF8E9099)
val dark_inverseOnSurface = Color(0xFF001F2A)
val dark_inverseSurface = Color(0xFFBFE9FF)
val dark_inversePrimary = Color(0xFF005CBA)
val dark_shadow = Color(0xFF000000)
val dark_surfaceTint = Color(0xFFABC7FF)
val dark_outlineVariant = Color(0xFF44474E)
val dark_scrim = Color(0xFF000000)

val light_badge = Color(0xFFEDF4FB)
val dark_badge = Color(0xFF334958)

val light_badge_icon = Color(0xFF4F4F4F)
val dark_badge_icon = Color(0xFFA8ADBD)

class ColorsHelper(
    val navigationBarColors: NavigationBarColors,
) {
    data class NavigationBarColors(
        val containerColor: Color,
        val contentColor: Color,
        val selectedIconColor: Color,
        val indicatorColor: Color,
        val selectedTextColor: Color,
        val unselectedIconColor: Color,
        val unselectedTextColor: Color,
    )
}

val DarkColorsHelper = ColorsHelper(
    navigationBarColors = ColorsHelper.NavigationBarColors(
        containerColor = Color.White,
        contentColor = Color.Black,
        indicatorColor = Color.Black,
        selectedIconColor = light_primary,
        selectedTextColor = Color.Black,
        unselectedIconColor = Color(0xFF828282),
        unselectedTextColor = Color(0xFF8F9090),
    )
)

val LightColorsHelper = ColorsHelper(
    navigationBarColors = ColorsHelper.NavigationBarColors(
        containerColor = Color.White,
        contentColor = Color.Black,
        indicatorColor = Color.White,
        selectedIconColor = light_primary,
        selectedTextColor = Color.Black,
        unselectedIconColor = Color(0xFF828282),
        unselectedTextColor = Color(0xFF8F9090),
    )
)

@Composable
fun ProvideColorsHelper(
    colorsHelper: ColorsHelper,
    content: @Composable () -> Unit
) {
    val colorsSet = remember { colorsHelper }
    CompositionLocalProvider(
        localColorsHelper provides colorsSet,
        content = content
    )
}

private val localColorsHelper = staticCompositionLocalOf { LightColorsHelper }

object ColorsProvider {
    private val local: ColorsHelper
        @Composable
        get() = localColorsHelper.current

    val navigationBarColors: ColorsHelper.NavigationBarColors
        @Composable
        get() = local.navigationBarColors
}