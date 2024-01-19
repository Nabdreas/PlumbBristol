package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun BookmarksListComponent(data: List<BathroomDetails>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items = data, itemContent = { bathroom ->
            BookmarksListItemComponent(data = bathroom)
        })
    }
}

@Preview
@Composable
fun BookmarksListComponentPreview() {
    PlumbBristolTheme {
        BookmarksListComponent(
            listOf(
                BathroomDetails(
                    id = "id",
                    title = "Top bathroom",
                    description = "incredible handy works",
                    price = "£1500",
                    duration = "7 days",
                    gallery = listOf("https://www.webdesign.org/img_articles/12668/bob_builder_34.jpg"),
                    isBookmarked = false
                )
            )
        )
    }
}