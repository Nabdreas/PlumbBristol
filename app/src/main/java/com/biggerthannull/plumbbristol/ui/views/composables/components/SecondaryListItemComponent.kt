package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.domain.usecase.models.Employee
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.elements.IconImageElement
import com.biggerthannull.plumbbristol.ui.views.composables.elements.ListDescription

@Composable
fun SecondaryListItemComponent(data: Employee) {
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
            IconImageElement(
                url = data.photoUrl,
                modifier = Modifier
                    .padding(16.dp)
                    .size(150.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp))),
                scale = ContentScale.FillWidth
            )
            ListDescription(
                modifier = Modifier,
                text = "Name: ${data.name}",
                color = Color.White
            )
            ListDescription(
                modifier = Modifier,
                text = "Position: ${data.position}",
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun SecondaryListItemComponentPreview() {
    PlumbBristolTheme {
        SecondaryListItemComponent(
            Employee(
                name = "Bob",
                age = "6",
                experience = "lifetime",
                photoUrl = "https://www.webdesign.org/img_articles/12668/bob_builder_34.jpg",
                position = "Builder"
            )
        )
    }
}