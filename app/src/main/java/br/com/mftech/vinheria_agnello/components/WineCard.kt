package br.com.mftech.vinheria_agnello.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mftech.vinheria_agnello.R
import br.com.mftech.vinheria_agnello.ui.theme.Sage
import br.com.mftech.vinheria_agnello.ui.theme.WineRed

/**
 * Representa um rótulo exibido em um [WineCard].
 * Nome, região e preço são referências de string (strings.xml), não texto solto.
 */
data class WineItem(
    @StringRes val nameRes: Int,
    @StringRes val regionRes: Int,
    @StringRes val priceRes: Int,
    val color: Color
)

/**
 * Card de rótulo de vinho: selo "climatizado", garrafa estilizada, nome,
 * região e preço. Reutilizável em qualquer grade/lista de produtos
 * (ex: vitrine da Home, catálogo completo, resultado de busca).
 *
 * @param wine dados do rótulo exibido.
 * @param modifier modificador opcional (ex: Modifier.weight(1f) numa Row).
 */
@Composable
fun WineCard(wine: WineItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .background(
                            color = Sage.copy(alpha = 0.14f),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 3.dp)
                ) {
                    Text(
                        stringResource(R.string.badge_climatizado),
                        color = Sage,
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .width(26.dp)
                        .height(64.dp)
                        .background(color = wine.color, shape = RoundedCornerShape(4.dp))
                )
            }
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Text(
                    stringResource(wine.nameRes),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    stringResource(wine.regionRes),
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    stringResource(wine.priceRes),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = WineRed
                )
            }
        }
    }
}
