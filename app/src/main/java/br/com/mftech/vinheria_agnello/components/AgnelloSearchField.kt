package br.com.mftech.vinheria_agnello.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Campo de busca padrão da Vinheria Agnello: cantos arredondados e ícone de lupa.
 * Reutilizável em qualquer tela que precise de busca (ex: Home, catálogo completo).
 *
 * @param value texto atual digitado.
 * @param onValueChange chamado a cada alteração do texto.
 * @param placeholder texto exibido quando o campo está vazio.
 * @param modifier modificador opcional (por padrão, ocupa a largura toda).
 */
@Composable
fun AgnelloSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        singleLine = true,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    )
}
