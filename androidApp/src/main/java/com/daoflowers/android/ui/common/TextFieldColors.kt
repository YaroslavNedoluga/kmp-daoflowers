package com.daoflowers.android.ui.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.daoflowers.android.ui.res.toColor
import com.daoflowers.sharing_resources.SharedRes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchTextFieldColors() : TextFieldColors = outlinedTextFieldColors(
    textColor = SharedRes.colors.Catalog_Search_Text.toColor(),
    containerColor = SharedRes.colors.Catalog_Search_Container.toColor(),
    cursorColor = SharedRes.colors.Catalog_Search_Cursor.toColor(),
    focusedBorderColor = Color.Transparent,
    unfocusedBorderColor = Color.Transparent,
    disabledBorderColor = Color.Transparent,
)
