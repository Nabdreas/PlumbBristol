package com.biggerthannull.plumbbristol.ui.views.composables.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.biggerthannull.plumbbristol.ui.theme.PlumbBristolTheme

@Composable
fun ListTitle(modifier: Modifier, text: String, color: Color) {
    Text(text = text, modifier = modifier, color = color, fontSize = 20.sp)
}

@Composable
fun ListDescription(text: String) {
    Text(text = text)
}

@Composable
fun ListExtraInfo(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun ListTitlePreview() {
    PlumbBristolTheme {
        ListTitle(modifier = Modifier, text = "I am title", color = Color.White)
    }
}

@Preview
@Composable
fun ListDescriptionPreview() {
    PlumbBristolTheme {
        ListDescription("I am description")
    }
}

@Preview
@Composable
fun ListExtraInfoPreview() {
    PlumbBristolTheme {
        ListExtraInfo("I am extra info")
    }
}