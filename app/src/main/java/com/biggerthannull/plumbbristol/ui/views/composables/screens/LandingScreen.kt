package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun LandingScreen() {
    Text(
        text = "Welcome to PlumbBristol"
    )
}

@Preview
@Composable
fun LandingScreenPreview() {
    PlumbBristolTheme {
        LandingScreen()
    }
}