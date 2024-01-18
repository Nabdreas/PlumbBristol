package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biggerthannull.plumbbristol.R
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.components.SecondaryVerticalListComponent
import com.biggerthannull.plumbbristol.ui.views.composables.elements.LoadingElement
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.TeamUIState

@Composable
fun TeamScreen(uiState: TeamUIState) {
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
    ) {
        when (uiState) {
            is TeamUIState.Success -> {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = "Meet the team",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 24.sp
                )
                SecondaryVerticalListComponent(data = uiState.data)
            }

            is TeamUIState.Loading -> {
                LoadingElement()
            }

            is TeamUIState.Failed -> {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.generic_error_label)
                )
            }
        }
    }
}

@Preview
@Composable
fun TeamScreenPreview() {
    PlumbBristolTheme {
        TeamScreen(uiState = TeamUIState.Loading)
    }
}