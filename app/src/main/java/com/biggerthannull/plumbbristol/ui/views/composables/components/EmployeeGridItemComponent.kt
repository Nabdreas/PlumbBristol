package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.R
import com.biggerthannull.plumbbristol.domain.usecase.models.Employee
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.elements.IconImageElement
import com.biggerthannull.plumbbristol.ui.views.composables.elements.ListDescription

@Composable
fun EmployeeGridItemComponent(data: Employee) {
    val employeePhotoAccessibilityLabel =
        stringResource(id = R.string.employee_image_accessibility_label)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        IconImageElement(
            url = data.photoUrl,
            modifier = Modifier
                .semantics {
                    contentDescription = employeePhotoAccessibilityLabel
                }
                .padding(16.dp)
                .size(150.dp)
                .clip(PlumbBristolTheme.shapes.large),
            scale = ContentScale.FillWidth
        )
        ListDescription(
            modifier = Modifier.semantics {
                contentDescription = data.name
            },
            text = data.name,
            color = PlumbBristolTheme.colour.white
        )
        ListDescription(
            modifier = Modifier.semantics {
                contentDescription = data.position
            },
            text = data.position,
            color = PlumbBristolTheme.colour.white
        )
    }
}

@Preview
@Composable
fun SecondaryListItemComponentPreview() {
    PlumbBristolTheme {
        EmployeeGridItemComponent(
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