package br.com.mftech.vinheria_agnello.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.mftech.vinheria_agnello.ui.theme.Gold
import br.com.mftech.vinheria_agnello.ui.theme.WineRedDark

/**
 * FloatingActionButton padrão da Vinheria Agnello: fundo dourado, ícone vinho escuro.
 * Reutilizável em qualquer tela.
 *
 * @param icon ícone exibido dentro do FAB.
 * @param contentDescription descrição para acessibilidade.
 * @param onClick ação ao tocar no FAB.
 */
@Composable
fun AgnelloFab(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = Gold,
        contentColor = WineRedDark
    ) {
        Icon(icon, contentDescription = contentDescription)
    }
}
