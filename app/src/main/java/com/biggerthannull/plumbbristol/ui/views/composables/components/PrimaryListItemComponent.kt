package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomOverview
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.elements.IconImageElement
import com.biggerthannull.plumbbristol.ui.views.composables.elements.ListTitle

@Composable
fun PrimaryListItemComponent(data: BathroomOverview, onClick: (itemId: String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(Color.Gray)
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
                .clip(RoundedCornerShape(corner = CornerSize(16.dp))),
            scale = ContentScale.Crop
        )
        ListTitle(
            modifier = Modifier
                .fillMaxWidth(),
            text = data.title,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PrimaryListItemComponentPreview() {
    PlumbBristolTheme {
        PrimaryListItemComponent(
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