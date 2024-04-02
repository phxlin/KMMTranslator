package me.yufan.kmmtranslator.android.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.yufan.kmmtranslator.android.R
import me.yufan.kmmtranslator.core.presentation.Colors

@Composable
fun TranslatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val darkColors = darkColors(
        primary = accentViolet,
        background = darkGrey,
        onPrimary = Color.White,
        onBackground = Color.White,
        surface = darkGrey,
        onSurface = Color.White
    )

    val lightColors = lightColors(
        primary = accentViolet,
        background = lightBlueGrey,
        onPrimary = Color.White,
        onBackground = textBlack,
        surface = Color.White,
        onSurface = textBlack
    )

    val colors = if (darkTheme) {
        darkColors
    } else {
        lightColors
    }

    val sfProText = FontFamily(
        Font(
            resId = R.font.sf_pro_text_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resId = R.font.sf_pro_text_medium,
            weight = FontWeight.Medium
        ),
        Font(
            resId = R.font.sf_pro_text_bold,
            weight = FontWeight.Bold
        )
    )

    val typography = Typography(
        h1 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
        h2 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        h3 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        ),
        body1 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        body2 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
    )

    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
