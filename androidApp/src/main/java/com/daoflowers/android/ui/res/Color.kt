package com.daoflowers.android.ui.res

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import dev.icerock.moko.resources.ColorResource

@Composable
fun ColorResource.toColor() : Color = colorResource(resourceId)