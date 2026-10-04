package br.com.mftech.vinheria_agnello.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mftech.vinheria_agnello.ui.theme.WineRed

/**
 * Botão primário padrão da Vinheria Agnello: fundo vinho, texto branco em
 * negrito, ocupando a largura toda. Reutilizável em qualquer formulário
 * do app (Login, Signup, futuro checkout, etc.).
 */
@Composable
fun AgnelloPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = WineRed, contentColor = Color.White),
        modifier = modifier
    ) {
        Text(text, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}
