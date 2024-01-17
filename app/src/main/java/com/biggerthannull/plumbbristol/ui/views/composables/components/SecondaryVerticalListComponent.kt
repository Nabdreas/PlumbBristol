package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.domain.usecase.models.Employee
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun SecondaryVerticalListComponent(data: List<Employee>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items = data, itemContent = { employee ->
            SecondaryListItemComponent(data = employee)
        })
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