package com.daoflowers.android.ui.catalog.flower

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.daoflowers.catalog.data.model.FlowerType
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BrokenImage
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daoflowers.android.R


@Composable
fun FlowerTypesScreen(
    viewModel: FlowerTypesViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.flowerTypes) {
                FlowerTypeCard(flowerType = it, onClick = {})
            }
        }

    }

}

@Composable
private fun FlowerTypeCard(
    flowerType: FlowerType,
    onClick: (FlowerType) -> Unit
) {
    Card(
        modifier = Modifier.size(100.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier.size(60.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(flowerType.imgUrl.orEmpty())
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_image),
                error = painterResource(R.drawable.ic_image_broken),
                contentDescription = null,
            )

            Text(
                text = flowerType.name,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}