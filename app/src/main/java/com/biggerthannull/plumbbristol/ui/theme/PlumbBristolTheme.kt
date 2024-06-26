package com.biggerthannull.plumbbristol.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object PlumbBristolTheme {
    val typography: PlumbBristolTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val colour: PlumbBristolColours
        @Composable
        @ReadOnlyComposable
        get() = LocalColours.current

    val shapes: PlumbBristolShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    @Immutable
    data class PlumbBristolTypography(
        val h1: TextStyle = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            letterSpacing = (-0.02).sp
        ),
        val h2: TextStyle = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            letterSpacing = (-0.01).sp
        ),
        val h3: TextStyle = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        ),
        val body: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = (-0.01).sp
        ),
        val button: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        ),
        val basicText: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp
        )
    )

    @Immutable
    data class PlumbBristolColours(
        val grey900: Color = Color.Unspecified,
        val grey800: Color = Color.Unspecified,
        val grey700: Color = Color.Unspecified,
        val grey600: Color = Color.Unspecified,
        val grey500: Color = Color.Unspecified,
        val grey400: Color = Color.Unspecified,
        val grey300: Color = Color.Unspecified,
        val grey200: Color = Color.Unspecified,
        val white: Color = Color.Unspecified,
        val black: Color = Color.Unspecified,
        val red: Color = Color.Unspecified
    )

    @Immutable
    data class PlumbBristolShapes(
        val small: Shape = RoundedCornerShape(8.0.dp),
        val medium: Shape = RoundedCornerShape(12.0.dp),
        val large: Shape = RoundedCornerShape(16.0.dp)
    )

    val LocalTypography = staticCompositionLocalOf {
        PlumbBristolTypography()
    }

    val LocalShapes = staticCompositionLocalOf {
        PlumbBristolShapes()
    }

    // reload values here?
    val LocalColours = staticCompositionLocalOf {
        PlumbBristolColours()
    }
}