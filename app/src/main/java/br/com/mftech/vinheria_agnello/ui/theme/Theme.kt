package br.com.mftech.vinheria_agnello.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = GoldLight,
    onPrimary = WineRedDark,
    secondary = Gold,
    onSecondary = WineRedDark,
    tertiary = Sage,
    onTertiary = Color.White,
    background = WineRedDark,
    onBackground = Cream,
    surface = Color(0xFF2A1810),
    onSurface = Cream
)

private val LightColorScheme = lightColorScheme(
    primary = WineRed,
    onPrimary = Color.White,
    primaryContainer = GoldLight,
    onPrimaryContainer = WineRedDark,
    secondary = Gold,
    onSecondary = WineRedDark,
    tertiary = Sage,
    onTertiary = Color.White,
    background = Cream,
    onBackground = Ink,
    surface = CreamSurface,
    onSurface = Ink,
    surfaceVariant = LineColor,
    onSurfaceVariant = InkSoft,
    outline = LineColor
)

@Composable
fun VinheriaagnelloTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Desligado por padrão: queremos sempre a identidade visual da Vinheria Agnello,
    // não as cores dinâmicas do papel de parede do usuário (Android 12+).
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
