package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.ui.resources.ImageLoader
import com.biggerthannull.plumbbristol.ui.resources.ImageLoaderImpl
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun GalleryHorizontalListComponent(data: List<String>) {
    val imageLoader: ImageLoader = ImageLoaderImpl()
    LazyRow {
        items(
            items = data,
            itemContent = { url ->
                imageLoader.Load(
                    url = url,
                    modifier = Modifier
                        .fillParentMaxSize()
                        .fillParentMaxHeight()
                        .width(300.dp)
                        .aspectRatio(
                            ratio = 1.33F
                        ),
                    contentDescription = null,
                    scale = ContentScale.Crop
                )
            }
        )
    }
}

@Preview
@Composable
fun GalleryHorizontalListComponentPreview() {
    PlumbBristolTheme {
        GalleryHorizontalListComponent(
            listOf(
                "https://curator-assets.b-cdn.net/54c93d3b-d832-4eee-bb76-5772e8e3f8c1/186828319.jpg",
                "https://curator-assets.b-cdn.net/54c93d3b-d832-4eee-bb76-5772e8e3f8c1/186828319.jpg",
                "https://curator-assets.b-cdn.net/54c93d3b-d832-4eee-bb76-5772e8e3f8c1/186828319.jpg"
            )
        )
    }
}