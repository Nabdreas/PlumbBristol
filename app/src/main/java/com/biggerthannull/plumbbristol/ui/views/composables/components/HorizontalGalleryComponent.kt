package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.elements.IconImageElement

@Composable
fun HorizontalGalleryComponent(images: List<String>) {
    val gallery = remember { images }
    LazyRow {
        items(
            items = gallery,
            itemContent = { image ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconImageElement(
                        url = image,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(150.dp)
                            .clip(RoundedCornerShape(corner = CornerSize(16.dp))),
                        scale = ContentScale.Crop
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun HorizontalListPreview() {
    PlumbBristolTheme {
        HorizontalGalleryComponent(listOf("posterUrl"))
    }
}