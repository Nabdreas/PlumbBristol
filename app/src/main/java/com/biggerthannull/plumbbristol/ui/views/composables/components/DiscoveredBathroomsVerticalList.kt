package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.domain.usecase.models.DiscoveredBathrooms
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.elements.IconImageElement

@Composable
fun DiscoveredBathroomsVerticalList(data: List<DiscoveredBathrooms>) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(items = data, itemContent = { bathroom ->
            IconImageElement(
                url = bathroom.imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(PlumbBristolTheme.shapes.large),
                scale = ContentScale.Crop
            )
        }
        )
    }
}

@Preview
@Composable
fun DiscoveredBathroomsVerticalListPreview() {
    PlumbBristolTheme {
        DiscoveredBathroomsVerticalList(data = emptyList())
    }
}