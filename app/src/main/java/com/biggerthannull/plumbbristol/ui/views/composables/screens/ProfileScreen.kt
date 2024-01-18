package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.plumbbristol.R
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.components.BookmarksListComponent
import com.biggerthannull.plumbbristol.ui.views.composables.elements.LoadingElement
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.ProfileUIState

@Composable
fun ProfileScreen(uiState: ProfileUIState) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
    ) {
        when (uiState) {
            is ProfileUIState.Success -> {
                if (uiState.bookmarked.isEmpty()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.empty_bookmarks)
                    )
                } else {
                    BookmarksListComponent(uiState.bookmarked)
                }
            }

            is ProfileUIState.Loading -> {
                LoadingElement()
            }

            is ProfileUIState.Error -> {
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
fun ProfileScreenPreview() {
    PlumbBristolTheme {
        ProfileScreen(ProfileUIState.Loading)
    }
}