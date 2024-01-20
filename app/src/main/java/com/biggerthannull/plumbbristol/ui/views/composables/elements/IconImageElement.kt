package com.biggerthannull.plumbbristol.ui.views.composables.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.plumbbristol.ui.resources.ImageLoader
import com.biggerthannull.plumbbristol.ui.resources.ImageLoaderImpl
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun IconImageElement(
    modifier: Modifier,
    url: String,
    imageLoad: ImageLoader = ImageLoaderImpl(),
    scale: ContentScale
) {
    imageLoad.Load(
        url = url,
        modifier = modifier,
        contentDescription = null,
        scale = scale
    )
}

@Preview
@Composable
fun IconImagePreview() {
    PlumbBristolTheme {
        IconImageElement(
            url = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/3f56fe3e-72c3-4400-a377-7b1216e9afec/dffxsyu-1ade2d19-6483-46bc-86ff-69113e5097cd.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzNmNTZmZTNlLTcyYzMtNDQwMC1hMzc3LTdiMTIxNmU5YWZlY1wvZGZmeHN5dS0xYWRlMmQxOS02NDgzLTQ2YmMtODZmZi02OTExM2U1MDk3Y2QucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0._UDriritjr6VvBivoLVsaKcQ3rF9FaNoyQ-eujFMvlI",
            modifier = Modifier
                .padding(8.dp)
                .size(84.dp)
                .clip(PlumbBristolTheme.shapes.large),
            scale = ContentScale.Crop
        )
    }
}