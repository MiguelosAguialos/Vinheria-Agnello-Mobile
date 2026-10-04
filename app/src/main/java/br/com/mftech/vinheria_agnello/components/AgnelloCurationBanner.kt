package br.com.mftech.vinheria_agnello.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mftech.vinheria_agnello.ui.theme.Gold
import br.com.mftech.vinheria_agnello.ui.theme.WineRedDark

/**
 * Banner de destaque (card vinho escuro + texto + botão dourado).
 * Usado na Home para o convite ao quiz do sommelier, mas serve pra
 * qualquer chamada de destaque (promoção, clube de assinatura, etc.).
 *
 * @param eyebrow texto pequeno acima do título (ex: "Sommelier virtual").
 * @param title título principal do banner.
 * @param text texto de apoio, abaixo do título.
 * @param ctaLabel texto do botão de ação.
 * @param onCtaClick ação ao tocar no botão.
 */
@Composable
fun AgnelloCurationBanner(
    eyebrow: String,
    title: String,
    text: String,
    ctaLabel: String,
    onCtaClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = WineRedDark),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                eyebrow.uppercase(),
                color = Gold,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
            Spacer(Modifier.height(4.dp))
            Text(
                title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text,
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 13.sp
            )
            Spacer(Modifier.height(12.dp))
            TextButton(
                onClick = onCtaClick,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Gold,
                    contentColor = WineRedDark
                )
            ) {
                Text(ctaLabel, fontWeight = FontWeight.Bold)
            }
        }
    }
}
