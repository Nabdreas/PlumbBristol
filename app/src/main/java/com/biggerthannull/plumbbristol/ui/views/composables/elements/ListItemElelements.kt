package com.biggerthannull.plumbbristol.ui.views.composables.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun ListTitle(modifier: Modifier, text: String, color: Color) {
    Text(text = text, modifier = modifier, color = color, style = PlumbBristolTheme.typography.h3)
}

@Composable
fun ListDescription(modifier: Modifier, text: String, color: Color) {
    Text(text = text, modifier = modifier, color = color, style = PlumbBristolTheme.typography.body)
}

@Composable
fun ListExtraInfo(text: String) {
    Text(text = text, style = PlumbBristolTheme.typography.basicText)
}

@Preview
@Composable
fun ListTitlePreview() {
    PlumbBristolTheme {
        ListTitle(
            modifier = Modifier,
            text = "I am title",
            color = PlumbBristolTheme.colour.white
        )
    }
}

@Preview
@Composable
fun ListDescriptionPreview() {
    PlumbBristolTheme {
        ListDescription(modifier = Modifier, text = "I am description", color = PlumbBristolTheme.colour.white)
    }
}

@Preview
@Composable
fun ListExtraInfoPreview() {
    PlumbBristolTheme {
        ListExtraInfo("I am extra info")
    }
}