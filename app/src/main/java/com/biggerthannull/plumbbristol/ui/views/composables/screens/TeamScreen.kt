package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.R
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.components.TeamOverviewGridComponent
import com.biggerthannull.plumbbristol.ui.views.composables.elements.LoadingElement
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.TeamUIState

@Composable
fun TeamScreen(uiState: TeamUIState) {
    Column(
        modifier = Modifier
            .background(PlumbBristolTheme.colour.grey800)
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
                    color = PlumbBristolTheme.colour.white,
                    style = PlumbBristolTheme.typography.h2
                )
                TeamOverviewGridComponent(data = uiState.data)
            }

            is TeamUIState.Loading -> {
                LoadingElement()
            }

            is TeamUIState.Failed -> {
                val errorLabel = stringResource(id = R.string.generic_error_label)
                Text(
                    modifier = Modifier.fillMaxWidth().semantics { contentDescription = errorLabel },
                    textAlign = TextAlign.Center,
                    text = errorLabel
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