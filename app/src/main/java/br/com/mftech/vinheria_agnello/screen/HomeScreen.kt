package br.com.mftech.vinheria_agnello.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.mftech.vinheria_agnello.R
import br.com.mftech.vinheria_agnello.components.AgnelloBottomNavItem
import br.com.mftech.vinheria_agnello.components.AgnelloBottomNavBar
import br.com.mftech.vinheria_agnello.components.AgnelloCategoryChips
import br.com.mftech.vinheria_agnello.components.AgnelloCurationBanner
import br.com.mftech.vinheria_agnello.components.AgnelloFab
import br.com.mftech.vinheria_agnello.components.AgnelloSearchField
import br.com.mftech.vinheria_agnello.components.AgnelloTopAppBar
import br.com.mftech.vinheria_agnello.components.WineCard
import br.com.mftech.vinheria_agnello.components.WineItem
import br.com.mftech.vinheria_agnello.ui.theme.Gold
import br.com.mftech.vinheria_agnello.ui.theme.Sage
import br.com.mftech.vinheria_agnello.ui.theme.VinheriaagnelloTheme
import br.com.mftech.vinheria_agnello.ui.theme.WineRed
import br.com.mftech.vinheria_agnello.ui.theme.WineRedDark

private fun wineCatalog(wineRed: Color, gold: Color, wineRedDark: Color, sage: Color) = listOf(
    WineItem(R.string.wine_1_name, R.string.wine_1_region, R.string.wine_1_price, wineRed),
    WineItem(R.string.wine_2_name, R.string.wine_2_region, R.string.wine_2_price, gold),
    WineItem(R.string.wine_3_name, R.string.wine_3_region, R.string.wine_3_price, wineRedDark),
    WineItem(R.string.wine_4_name, R.string.wine_4_region, R.string.wine_4_price, sage)
)

private val categoryLabelRes = listOf(
    R.string.category_all,
    R.string.category_red,
    R.string.category_white,
    R.string.category_sparkling,
    R.string.category_club
)



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var busca by remember { mutableStateOf("") }
    var categoriaSelecionada by remember { mutableIntStateOf(0) }

    val wines = wineCatalog(WineRed, Gold, WineRedDark, Sage)
    val categoryLabels = categoryLabelRes.map { stringResource(it) }

    Scaffold(
        topBar = {
            AgnelloTopAppBar(
                title = stringResource(R.string.home_top_bar_title),
                actions = {
                    IconButton(onClick = { /* tela do carrinho: fora do escopo deste protótipo */ }) {
                        Icon(
                            Icons.Filled.ShoppingCart,
                            contentDescription = stringResource(R.string.home_cart_content_description)
                        )
                    }
                }
            )
        },
        bottomBar = {
            AgnelloBottomNavBar(
                items = listOf(
                    AgnelloBottomNavItem(Icons.Filled.Home, stringResource(R.string.bottom_nav_home)) { /* já está na Home */ },
                    AgnelloBottomNavItem(Icons.Filled.Search, stringResource(R.string.bottom_nav_search)) { /* busca: fora do escopo deste protótipo */ },
                    AgnelloBottomNavItem(Icons.Filled.ShoppingCart, stringResource(R.string.bottom_nav_cart)) { /* tela do carrinho: fora do escopo deste protótipo */ },
                    AgnelloBottomNavItem(Icons.Filled.Person, stringResource(R.string.bottom_nav_profile)) { /* tela de perfil: fora do escopo deste protótipo */ }
                )
            )
        },
        floatingActionButton = {
            AgnelloFab(
                icon = Icons.Filled.LocalBar,
                contentDescription = stringResource(R.string.fab_quiz_content_description),
                onClick = { /* tela do quiz do sommelier: fora do escopo deste protótipo */ }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
        ) {
            Spacer(Modifier.height(16.dp))

            AgnelloSearchField(
                value = busca,
                onValueChange = { busca = it },
                placeholder = stringResource(R.string.home_search_placeholder)
            )

            Spacer(Modifier.height(14.dp))

            AgnelloCategoryChips(
                categories = categoryLabels,
                selectedIndex = categoriaSelecionada,
                onSelect = { categoriaSelecionada = it }
            )

            Spacer(Modifier.height(18.dp))

            AgnelloCurationBanner(
                eyebrow = stringResource(R.string.curation_eyebrow),
                title = stringResource(R.string.curation_title),
                text = stringResource(R.string.curation_text),
                ctaLabel = stringResource(R.string.curation_cta),
                onCtaClick = { /* tela do quiz do sommelier: fora do escopo deste protótipo */ }
            )

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    stringResource(R.string.section_selected_title),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                TextButton(onClick = { /* catálogo completo: fora do escopo deste protótipo */ }) {
                    Text(stringResource(R.string.section_see_all), color = WineRed, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(Modifier.height(8.dp))

            wines.chunked(2).forEach { pair ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    pair.forEach { wine ->
                        WineCard(wine = wine, modifier = Modifier.weight(1f))
                    }
                    if (pair.size < 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
                Spacer(Modifier.height(12.dp))
            }

            Spacer(Modifier.height(16.dp))
        }
    }
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun HomeScreenPreview() {
    VinheriaagnelloTheme {
        HomeScreen()
    }
}
