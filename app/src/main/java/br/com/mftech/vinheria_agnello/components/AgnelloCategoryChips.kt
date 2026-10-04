package br.com.mftech.vinheria_agnello.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.mftech.vinheria_agnello.ui.theme.WineRed

/**
 * Linha de chips de categoria com rolagem horizontal e seleção única.
 * Reutilizável em qualquer tela de listagem/filtro (ex: Home, catálogo completo).
 *
 * @param categories rótulos já traduzidos (resolvidos com stringResource pelo chamador).
 * @param selectedIndex índice do chip selecionado.
 * @param onSelect chamado com o índice do chip tocado.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgnelloCategoryChips(
    categories: List<String>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit
) {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        categories.forEachIndexed { index, label ->
            FilterChip(
                selected = selectedIndex == index,
                onClick = { onSelect(index) },
                label = { Text(label) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = WineRed,
                    selectedLabelColor = Color.White
                )
            )
        }
    }
}
