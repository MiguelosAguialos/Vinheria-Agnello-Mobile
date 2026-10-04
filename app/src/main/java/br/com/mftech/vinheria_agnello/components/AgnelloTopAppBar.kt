package br.com.mftech.vinheria_agnello.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import br.com.mftech.vinheria_agnello.ui.theme.WineRed

/**
 * TopAppBar padrão da Vinheria Agnello: fundo vinho, título e ícones em branco.
 * Reutilizável em qualquer tela (Home, Login, Signup, etc.).
 *
 * @param title texto exibido na barra.
 * @param showBackButton se true, mostra a seta de voltar à esquerda.
 * @param onBackClick ação da seta de voltar (ignorado se showBackButton = false).
 * @param actions ícones extras à direita da barra (ex: carrinho). Opcional.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgnelloTopAppBar(
    title: String,
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = { Text(title, fontWeight = FontWeight.SemiBold) },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                }
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = WineRed,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}
