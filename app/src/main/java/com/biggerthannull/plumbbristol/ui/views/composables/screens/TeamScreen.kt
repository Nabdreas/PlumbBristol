package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun TeamScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Meet the team",
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun TeamScreenPreview() {
    PlumbBristolTheme {
        TeamScreen()
    }
}