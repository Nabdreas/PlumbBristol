package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.components.GalleryHorizontalListComponent
import com.biggerthannull.plumbbristol.ui.views.composables.elements.LoadingElement
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState.Success
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState.Loading

@Composable
fun BathroomDetailsScreen(uiState: BathroomDetailsUIState) {
    val scrollableState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .verticalScroll(scrollableState)
    ) {
        when (uiState) {
            is Success -> {
                GalleryHorizontalListComponent(data = uiState.bathroom.gallery)
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    color = Color.White,
                    text = uiState.bathroom.description,
                    textAlign = TextAlign.Start
                )
            }

            is Loading -> {
                LoadingElement()
            }

            else -> {
                Text(text = "You have failed")
            }
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