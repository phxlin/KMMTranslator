package me.yufan.kmmtranslator.android.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
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
    val accentViolet = Color(Colors.AccentViolet)
    val lightBlue = Color(Colors.LightBlue)
    val lightBlueGrey = Color(Colors.LightBlueGrey)
    val textBlack = Color(Colors.TextBlack)
    val darkGrey = Color(Colors.DarkGrey)

    val colors = if (darkTheme) {
        darkColorScheme(
            primary = accentViolet,
            background = darkGrey,
            onPrimary = Color.White,
            onBackground = Color.White,
            surface = darkGrey,
            onSurface = Color.White,
            secondary = Color(0xFF03DAC5),
            tertiary = Color(0xFF3700B3)
        )
    } else {
        lightColorScheme(
            primary = accentViolet,
            background = lightBlueGrey,
            onPrimary = Color.White,
            onBackground = textBlack,
            surface = Color.White,
            onSurface = textBlack,
            secondary = Color(0xFF03DAC5),
            tertiary = Color(0xFF3700B3)
        )
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
        headlineLarge = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    )

    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
