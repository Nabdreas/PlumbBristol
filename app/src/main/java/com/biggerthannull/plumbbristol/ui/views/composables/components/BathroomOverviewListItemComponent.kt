package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.elements.IconImageElement
import com.biggerthannull.plumbbristol.ui.views.composables.elements.ListTitle

@Composable
fun BathroomOverviewListItemComponent(data: BathroomOverview, onClick: (itemId: String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(PlumbBristolTheme.colour.grey700)
            .selectable(true, onClick = {
                onClick(data.id)
            }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconImageElement(
            url = data.coverImage,
            modifier = Modifier
                .padding(8.dp)
                .size(84.dp)
                .clip(PlumbBristolTheme.shapes.large),
            scale = ContentScale.Crop
        )
        ListTitle(
            modifier = Modifier
                .fillMaxWidth(),
            text = data.title,
            color = PlumbBristolTheme.colour.white
        )
    }
}

@Preview
@Composable
fun BathroomOverviewListItemComponentPreview() {
    PlumbBristolTheme {
        BathroomOverviewListItemComponent(
            BathroomOverview(
                id = "id",
                title = "I am a title",
                coverImage = "http://www.plumbbristol.co.uk/uploads/1/0/8/9/10898263/1410295243.jpg"
            ), onClick = {
                // no-op
            }
        )
    }
}