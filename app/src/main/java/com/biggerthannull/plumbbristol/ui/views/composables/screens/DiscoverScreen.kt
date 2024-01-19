package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.plumbbristol.R
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.components.DiscoveredBathroomsVerticalList
import com.biggerthannull.plumbbristol.ui.views.composables.elements.LoadingElement
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.DiscoverUIState

@Composable
fun DiscoverScreen(uiState: DiscoverUIState) {
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (uiState) {
            is DiscoverUIState.Loading -> {
                LoadingElement()
            }

            is DiscoverUIState.Error -> {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.generic_error_label)
                )
            }

            is DiscoverUIState.Success -> {
                DiscoveredBathroomsVerticalList(data = uiState.bathrooms)
            }
        }
    }
}

@Preview
@Composable
fun DiscoverScreenPreview() {
    PlumbBristolTheme {
        DiscoverScreen(DiscoverUIState.Success(emptyList()))
    }
}

