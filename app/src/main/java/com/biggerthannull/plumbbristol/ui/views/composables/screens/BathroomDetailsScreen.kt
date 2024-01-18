package com.biggerthannull.plumbbristol.ui.views.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.domain.usecase.models.BathroomDetails
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme
import com.biggerthannull.plumbbristol.ui.views.composables.components.GalleryHorizontalListComponent
import com.biggerthannull.plumbbristol.ui.views.composables.elements.LoadingElement
import com.biggerthannull.plumbbristol.ui.views.viewmodels.events.DetailsUserEvents
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState.Success
import com.biggerthannull.plumbbristol.ui.views.viewmodels.state.BathroomDetailsUIState.Loading

@Composable
fun BathroomDetailsScreen(uiState: BathroomDetailsUIState, userEvents: DetailsUserEvents) {
    val scrollableState = rememberScrollState()
    var isAdded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .verticalScroll(scrollableState)
    ) {
        when (uiState) {
            is Success -> {
                GalleryHorizontalListComponent(data = uiState.bathroom.gallery)
                IconToggleButton(
                    checked = isAdded,
                    onCheckedChange = {
                        userEvents.bookmarkBathroom(uiState.bathroom)
                        isAdded = !isAdded
                    }
                ) {
                    Icon(
                        tint = Color.Red,
                        modifier = Modifier.graphicsLayer {
                            scaleX = 1.3f
                            scaleY = 1.3f
                        },
                        imageVector = if (isAdded) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Default.FavoriteBorder
                        },
                        contentDescription = "Bookmark"
                    )
                }
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
        BathroomDetailsScreen(
            uiState = Loading,
            userEvents = object : DetailsUserEvents {
                override fun bookmarkBathroom(data: BathroomDetails) {
                    // no-op
                }

            })
    }
}