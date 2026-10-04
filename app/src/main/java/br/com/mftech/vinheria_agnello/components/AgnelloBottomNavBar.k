package br.com.mftech.vinheria_agnello.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.mftech.vinheria_agnello.ui.theme.WineRedDark

/**
 * Um item da barra de navegação inferior (ícone + ação).
 */
data class AgnelloBottomNavItem(
    val icon: ImageVector,
    val contentDescription: String,
    val onClick: () -> Unit
)

/**
 * BottomAppBar de navegação da Vinheria Agnello: fundo vinho escuro,
 * ícones distribuídos igualmente. Reutilizável em qualquer tela que
 * precise de navegação inferior (ex: Home, catálogo, perfil).
 *
 * @param items lista de ícones e ações exibidos, da esquerda pra direita.
 */
@Composable
fun AgnelloBottomNavBar(items: List<AgnelloBottomNavItem>) {
    BottomAppBar(
        containerColor = WineRedDark,
        contentColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                IconButton(onClick = item.onClick) {
                    Icon(item.icon, contentDescription = item.contentDescription)
                }
            }
        }
    }
}
