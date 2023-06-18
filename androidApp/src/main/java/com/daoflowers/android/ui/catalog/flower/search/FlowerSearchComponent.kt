@file:OptIn(ExperimentalMaterial3Api::class)

package com.daoflowers.android.ui.catalog.flower.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daoflowers.android.R
import com.daoflowers.android.ui.catalog.flower.search.FlowerSearchViewModel.*
import com.daoflowers.android.ui.catalog.flower.search.FlowerSearchViewModel.SideEffect.*
import com.daoflowers.android.ui.common.SingleLineText
import com.daoflowers.android.ui.common.TextStyles.GilroyTextStyle
import com.daoflowers.android.ui.common.TextStyles.InterTextStyle
import com.daoflowers.android.ui.common.searchTextFieldColors
import com.daoflowers.android.ui.res.stringResource
import com.daoflowers.android.ui.res.toColor
import com.daoflowers.catalog.ui.flower.search.FlowerSearchItem
import com.daoflowers.sharing_resources.SharedRes
import org.koin.androidx.compose.koinViewModel

@Composable
fun FlowerSearchComponent(
    modifier: Modifier = Modifier,
    viewModel: FlowerSearchViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val onSideEffect = viewModel::onSideEffect

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FlowerSearch(
            state = state,
            onValueChange = { onSideEffect(SearchChanged(it)) },
        )

        AnimatedVisibility(visible = state.showSearchItems) {
            FlowerSearchList(
                state = state,
                onSearchItemClick = { onSideEffect(SearchItemClicked(it)) }
            )
        }
    }
}

@Composable
fun FlowerSearch(
    modifier: Modifier = Modifier,
    focusManager: FocusManager = LocalFocusManager.current,
    state: SearchState,
    onValueChange: (String) -> Unit,
) = with(state) {
    Surface(
        modifier = Modifier
            .background(Color.Transparent)
            .clip(RoundedCornerShape(8.dp)),
        shadowElevation = if (showSearchItems) 8.dp else 0.dp,
    ) {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp),
            singleLine = true,
            shape = RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 32.dp,
                bottomStart = if (showSearchItems.not()) 32.dp else 0.dp,
                bottomEnd = if (showSearchItems.not()) 32.dp else 0.dp,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    focusManager.clearFocus()
                }
            ),
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                SingleLineText(
                    text = stringResource(SharedRes.strings.search),
                    style = InterTextStyle.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = SharedRes.colors.Catalog_Search_Placeholder.toColor()
                    )
                )
            },
            leadingIcon = {
                if (value.isBlank()) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = SharedRes.images.Search.drawableResId),
                        contentDescription = null,
                        tint = SharedRes.colors.Catalog_Search_Icon.toColor()
                    )
                } else {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(onClick = {
                                onValueChange("")
                                focusManager.clearFocus()
                            }),
                        painter = painterResource(id = SharedRes.images.ArrowLeft.drawableResId),
                        contentDescription = null,
                        tint = SharedRes.colors.Catalog_Search_Icon.toColor()
                    )
                }
            },
            textStyle = InterTextStyle.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = SharedRes.colors.Catalog_Search_Text.toColor()
            ),
            trailingIcon = {
                if (value.isNotBlank()) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(onClick = {
                                onValueChange("")
                                focusManager.clearFocus()
                            }),
                        painter = painterResource(id = SharedRes.images.Close.drawableResId),
                        contentDescription = null,
                        tint = SharedRes.colors.Catalog_Search_Icon.toColor(),
                    )
                } else {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(onClick = { }),
                        painter = painterResource(id = SharedRes.images.Filter.drawableResId),
                        contentDescription = null,
                        tint = SharedRes.colors.Catalog_Search_Icon.toColor(),
                    )
                }
            },
            colors = searchTextFieldColors()
        )
    }
}

@Composable
fun FlowerSearchList(
    state: SearchState,
    onSearchItemClick: (FlowerSearchItem) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = SharedRes.colors.Catalog_Search_Container.toColor(),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 32.dp,
                    bottomEnd = 32.dp,
                )
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = SharedRes.colors.Catalog_Search_Icon.toColor()
        )

        state.searchItems.take(3).forEach {
            SearchItemRow(
                flower = it,
                onClick = { onSearchItemClick(it) }
            )
        }

        if (state.searching) {
            LoadingItemRow()
        }

        if (state.searchingFailed) {
            TextItemRow(
                modifier = Modifier.padding(horizontal = 18.dp),
                text = stringResource(SharedRes.strings.search_error)
            )
        }

        if (state.showEmptyResults) {
            TextItemRow(
                modifier = Modifier.padding(horizontal = 18.dp),
                text = stringResource(SharedRes.strings.search_empty_results)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun SearchItemRow(
    modifier: Modifier = Modifier,
    flower: FlowerSearchItem,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 18.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(flower.image.orEmpty())
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_image),
            error = painterResource(R.drawable.ic_image_broken),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = flower.name.capitalize(Locale.current),
                textAlign = TextAlign.Start,
                style = GilroyTextStyle.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            if (flower.size.isNotEmpty()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = SharedRes.images.Measuring.drawableResId),
                        contentDescription = null,
                        tint = SharedRes.colors.Catalog_Search_RowIcon.toColor()
                    )

                    Text(
                        text = flower.size.capitalize(Locale.current),
                        textAlign = TextAlign.Start,
                        style = InterTextStyle.copy(
                            fontSize = 14.sp,
                            color = SharedRes.colors.Catalog_Search_RowIcon.toColor()
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun TextItemRow(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Start,
        style = GilroyTextStyle.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        )
    )
}

@Composable
fun LoadingItemRow() {
    Box(modifier = Modifier.fillMaxWidth()) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .size(44.dp),
            color = SharedRes.colors.Catalog_Search_Icon.toColor()
        )
    }
}