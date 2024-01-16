package com.biggerthannull.plumbbristol.ui.views.composables.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun TopBarComponent() {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Plumb Bristol",
                color = Color.White,
                textAlign = TextAlign.Center
            )
        },
        backgroundColor = Color.Black,
        elevation = 10.dp
    )
}

@Preview
@Composable
fun TopBarComponentPreview() {
    PlumbBristolTheme {
        TopBarComponent()
    }
}