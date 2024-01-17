package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState.Success

@Composable
fun BathroomDetailsScreen(uiState: BathroomDetailsUIState) {
    when (uiState) {
        is Success -> {
            Text(text = "Welcome to bathroom id: ${uiState.bathroom.title}")
        }
        else -> {
            Text(text = "You have failed")
        }
    }
}

@Preview
@Composable
fun BathroomDetailsScreenPreview() {
    PlumbBristolTheme {
        BathroomDetailsScreen(BathroomDetailsUIState.Loading)
    }
}