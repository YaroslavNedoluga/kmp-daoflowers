package com.daoflowers.android.ui.catalog.flower

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daoflowers.android.R
import com.daoflowers.android.ui.theme.light_badge
import com.daoflowers.android.ui.theme.light_badge_icon
import com.daoflowers.catalog.data.model.FlowerType
import org.koin.androidx.compose.koinViewModel


@Composable
fun FlowerTypesScreen(
    viewModel: FlowerTypesViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    FlowerTypeScreenContent(state = state)
}

@Composable
private fun FlowerTypeScreenContent(
    state: FlowerTypesViewModel.State,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(25.dp),
            columns = GridCells.Adaptive(145.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            items(state.flowerTypes) {
                FlowerTypeCard(
                    flowerType = it,
                    onClick = { _ ->

                    }
                )
            }
        }
    }
}

@Composable
private fun FlowerTypeCard(
    flowerType: FlowerType,
    onClick: (FlowerType) -> Unit
) {
    Surface(
        modifier = Modifier.height(160.dp),
        shape = CardDefaults.shape,
        shadowElevation = 6.dp,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(114.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(flowerType.imgUrl.orEmpty())
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_image),
                error = painterResource(R.drawable.ic_image_broken),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                text = flowerType.name.capitalize(Locale.current),
                textAlign = TextAlign.Start,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Row(
                modifier = Modifier
                    .padding(
                        start = 4.dp,
                        end = 4.dp,
                        bottom = 4.dp
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CardBadge(
                    modifier = Modifier.size(
                        width = 80.dp,
                        height = 16.dp
                    ),
                    text = stringResource(id = R.string.count_sorts, flowerType.sortsCount ?: 0),
                    iconId = R.drawable.ic_flower,
                    iconStart = true
                )

                Spacer(modifier = Modifier.weight(1f))

                CardBadge(
                    modifier = Modifier.size(
                        width = 48.dp,
                        height = 16.dp
                    ),
                    text = (flowerType.imagesCount ?: 0).toString(),
                    iconId = R.drawable.ic_photo,
                    iconStart = false
                )
            }
        }
    }
}

@Composable
fun CardBadge(
    modifier: Modifier = Modifier,
    text: String,
    iconId: Int,
    iconStart: Boolean = true,
) {
    Row(
        modifier = modifier
            .background(
                color = light_badge,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (iconStart) Arrangement.Start else Arrangement.End
    ) {

        if (iconStart) {
            Icon(
                modifier = Modifier.size(10.dp),
                painter = painterResource(id = iconId),
                contentDescription = null,
                tint = light_badge_icon
            )
            Spacer(modifier = Modifier.width(4.dp))
        }

        Text(
            modifier = Modifier.fillMaxHeight(),
            text = text,
            color = light_badge_icon,
            fontSize = 10.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Normal
            )
        )

        if (!iconStart) {
            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                modifier = Modifier.size(10.dp),
                painter = painterResource(id = iconId),
                contentDescription = null,
                tint = light_badge_icon
            )
        }
    }
}