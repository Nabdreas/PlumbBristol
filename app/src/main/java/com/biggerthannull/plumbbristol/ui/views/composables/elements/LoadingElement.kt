package com.biggerthannull.plumbbristol.ui.views.composables.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.plumbbristol.R
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun LoadingElement() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val loadingText = stringResource(id = R.string.loading)
            CircularProgressIndicator(
                modifier = Modifier.semantics { contentDescription = loadingText }
            )
        }
    }
}

@Preview
@Composable
fun LoadingElementPreview() {
    PlumbBristolTheme {
        LoadingElement()
    }
}