package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun ContactUsScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Here you can find booking form and more about the team",
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ContactUsScreenPreview() {
    PlumbBristolTheme {
        ContactUsScreen()
    }
}