package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.elements.ListDescription

@Composable
fun BookmarksListItemComponent(data: BathroomDetails) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Column(
            Modifier
                .background(Color.Gray)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            HorizontalGalleryComponent(data.gallery)
            ListDescription(
                modifier = Modifier.padding(16.dp),
                text = data.description,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun BookmarksListItemComponentPreview() {
    PlumbBristolTheme {
        BookmarksListItemComponent(
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
    }
}