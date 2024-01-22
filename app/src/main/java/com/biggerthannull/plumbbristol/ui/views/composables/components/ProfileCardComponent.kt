package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.elements.IconImageElement

@Composable
fun ProfileCardComponent(size: Int) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(PlumbBristolTheme.colour.black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconImageElement(
                url = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/84707089-0625-40f8-9416-da48a7e76fa8/df4jccf-421b782b-0d79-4058-8935-b8763c42d0b4.png/v1/fill/w_792,h_743,q_80,strp/character_icons__randy_marsh_by_cartman1235_df4jccf-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NzQzIiwicGF0aCI6IlwvZlwvODQ3MDcwODktMDYyNS00MGY4LTk0MTYtZGE0OGE3ZTc2ZmE4XC9kZjRqY2NmLTQyMWI3ODJiLTBkNzktNDA1OC04OTM1LWI4NzYzYzQyZDBiNC5wbmciLCJ3aWR0aCI6Ijw9NzkyIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.QqPrNjMPAGcnkNRiTQTm279NkOZAi6MP7C5UVV0ewf4",
                modifier = Modifier
                    .size(120.dp)
                    .clip(PlumbBristolTheme.shapes.large),
                scale = ContentScale.Crop
            )
            PersonalStatsSection(size)
        }
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            maxLines = 2,
            text = "Randy Marsh",
            color = PlumbBristolTheme.colour.white,
            style = PlumbBristolTheme.typography.h3
        )
    }
}

@Composable
private fun PersonalStatsSection(size: Int) {
    Column(
        Modifier
            .padding(8.dp)
    ) {
        Text(text = "$size", color = PlumbBristolTheme.colour.white)
        Text(text = "Bookmarks", color = PlumbBristolTheme.colour.white)
    }
}

@Preview
@Composable
fun ProfileCardComponentPreview() {
    PlumbBristolTheme {
        ProfileCardComponent(0)
    }
}