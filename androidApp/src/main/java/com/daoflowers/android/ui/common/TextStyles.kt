package com.daoflowers.android.ui.common

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import com.daoflowers.android.ui.theme.GilroyFontFamily
import com.daoflowers.android.ui.theme.InterFontFamily

object TextStyles {

    @Stable
    val GilroyTextStyle = TextStyle().gilroyFontFamily()

    @Stable
    val InterTextStyle = TextStyle().interFontFamily()

}

fun TextStyle.includeFontPadding(includeFontPadding: Boolean): TextStyle {
    return this.copy(
        platformStyle = PlatformTextStyle(
            includeFontPadding = includeFontPadding
        )
    )
}

fun TextStyle.gilroyFontFamily(includeFontPadding: Boolean = false): TextStyle {
    return this.includeFontPadding(includeFontPadding).addFontFamily(GilroyFontFamily)
}

fun TextStyle.interFontFamily(includeFontPadding: Boolean = false): TextStyle {
    return this.includeFontPadding(includeFontPadding).addFontFamily(InterFontFamily)
}

private fun TextStyle.addFontFamily(fontFamily: FontFamily): TextStyle {
    return this.copy(fontFamily = fontFamily)
}