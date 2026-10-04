package br.com.mftech.vinheria_agnello.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

/**
 * Campo de texto padrão da Vinheria Agnello: cantos arredondados e ícone à
 * esquerda opcional. Reutilizável em qualquer formulário do app
 * (Login, Signup, futuras telas de perfil/checkout).
 *
 * @param leadingIcon ícone exibido à esquerda do campo (opcional).
 * @param trailingIcon conteúdo exibido à direita do campo (opcional, ex: um IconButton).
 * @param readOnly quando true, o campo não aceita digitação (útil combinado com
 * um trailingIcon que abre um seletor, ex: data de nascimento).
 */
@Composable
fun AgnelloTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    placeholder: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = placeholder?.let { { Text(it) } },
        leadingIcon = leadingIcon?.let { icon -> { Icon(icon, contentDescription = null) } },
        trailingIcon = trailingIcon,
        singleLine = singleLine,
        readOnly = readOnly,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    )
}
