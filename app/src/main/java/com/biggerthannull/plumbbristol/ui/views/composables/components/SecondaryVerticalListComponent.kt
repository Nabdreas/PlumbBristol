package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.plumbbristol.domain.usecase.models.Employee
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun SecondaryVerticalListComponent(data: List<Employee>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(data) {  employee ->
            SecondaryListItemComponent(data = employee)
        }
    }
}

@Preview
@Composable
fun SecondaryVerticalListComponentPreview() {
    PlumbBristolTheme {
        SecondaryVerticalListComponent(
            listOf(
                Employee(
                    name = "Bob",
                    age = "6",
                    experience = "lifetime",
                    photoUrl = "https://www.webdesign.org/img_articles/12668/bob_builder_34.jpg",
                    position = "Builder"
                )
            )
        )
    }
}