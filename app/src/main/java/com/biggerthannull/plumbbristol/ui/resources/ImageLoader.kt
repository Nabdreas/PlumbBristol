package com.biggerthannull.plumbbristol.ui.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

interface ImageLoader {
    @Composable
    fun Load(
        url: String,
        modifier: Modifier,
        contentDescription: String?,
        scale: ContentScale
    )
}