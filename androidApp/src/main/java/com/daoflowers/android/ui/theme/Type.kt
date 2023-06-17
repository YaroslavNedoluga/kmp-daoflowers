package com.daoflowers.android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.daoflowers.sharing_resources.SharedRes

val InterFontFamily = FontFamily(
    Font(resId = SharedRes.fonts.Inter.black.fontResourceId, weight = FontWeight.Black),
    Font(resId = SharedRes.fonts.Inter.bold.fontResourceId, weight = FontWeight.Bold),
    Font(resId = SharedRes.fonts.Inter.extraBold.fontResourceId, weight = FontWeight.ExtraBold),
    Font(resId = SharedRes.fonts.Inter.extraLight.fontResourceId, weight = FontWeight.ExtraLight),
    Font(resId = SharedRes.fonts.Inter.light.fontResourceId, weight = FontWeight.Light),
    Font(resId = SharedRes.fonts.Inter.medium.fontResourceId, weight = FontWeight.Medium),
    Font(resId = SharedRes.fonts.Inter.regular.fontResourceId, weight = FontWeight.Normal),
    Font(resId = SharedRes.fonts.Inter.semiBold.fontResourceId, weight = FontWeight.SemiBold),
    Font(resId = SharedRes.fonts.Inter.thin.fontResourceId, weight = FontWeight.Thin),
)

val GilroyFontFamily = FontFamily(
    Font(resId = SharedRes.fonts.Gilroy.black.fontResourceId, weight = FontWeight.Black),
    Font(resId = SharedRes.fonts.Gilroy.bold.fontResourceId, weight = FontWeight.Bold),
    Font(resId = SharedRes.fonts.Gilroy.extraBold.fontResourceId, weight = FontWeight.ExtraBold),
    Font(resId = SharedRes.fonts.Gilroy.light.fontResourceId, weight = FontWeight.Light),
    Font(resId = SharedRes.fonts.Gilroy.medium.fontResourceId, weight = FontWeight.Medium),
    Font(resId = SharedRes.fonts.Gilroy.regular.fontResourceId, weight = FontWeight.Normal),
    Font(resId = SharedRes.fonts.Gilroy.semiBold.fontResourceId, weight = FontWeight.SemiBold),
    Font(resId = SharedRes.fonts.Gilroy.thin.fontResourceId, weight = FontWeight.Thin),
)

// Material 3 typography
val replyTypography = Typography(
    headlineLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)