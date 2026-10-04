package br.com.mftech.vinheria_agnello.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mftech.vinheria_agnello.ui.theme.Gold
import br.com.mftech.vinheria_agnello.ui.theme.WineRedDark

/**
 * BottomAppBar de "mensagem + ação" da Vinheria Agnello: fundo vinho escuro,
 * um texto informativo e um botão de ação em dourado, centralizados.
 *
 * Reutilizável em qualquer tela de autenticação — usada hoje no Login
 * ("Não possui uma conta? Registrar-se") e no Cadastro
 * ("Já possui uma conta? Entrar"). Diferente da [AgnelloBottomNavBar],
 * que é uma barra de navegação por ícones (usada na Home).
 */
@Composable
fun AgnelloBottomMessageBar(
    message: String,
    actionLabel: String,
    onActionClick: () -> Unit
) {
    BottomAppBar(
        containerColor = WineRedDark,
        contentColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(message, color = Color.White, fontSize = 16.sp)
            TextButton(onClick = onActionClick) {
                Text(actionLabel, color = Gold, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}
