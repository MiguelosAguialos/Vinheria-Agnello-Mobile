package br.com.mftech.vinheria_agnello.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mftech.vinheria_agnello.R
import br.com.mftech.vinheria_agnello.components.AgnelloBottomMessageBar
import br.com.mftech.vinheria_agnello.components.AgnelloFab
import br.com.mftech.vinheria_agnello.components.AgnelloPasswordField
import br.com.mftech.vinheria_agnello.components.AgnelloPrimaryButton
import br.com.mftech.vinheria_agnello.components.AgnelloTextField
import br.com.mftech.vinheria_agnello.components.AgnelloTopAppBar
import br.com.mftech.vinheria_agnello.ui.theme.VinheriaagnelloTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navigateToLogin: () -> Unit) {
    var nome by remember { mutableStateOf("") }
    var dataNascimento by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            AgnelloTopAppBar(
                title = stringResource(R.string.create_account),
                showBackButton = true,
                onBackClick = navigateToLogin
            )
        },
        bottomBar = {
            AgnelloBottomMessageBar(
                message = stringResource(R.string.already_has_account),
                actionLabel = stringResource(R.string.login),
                onActionClick = navigateToLogin
            )
        },

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.winesignuppage),
                contentDescription = stringResource(R.string.content_desc_wine_signup_logo),
                modifier = Modifier
                    .size(150.dp)
                    .padding(20.dp)
            )
            Text(
                stringResource(R.string.create_your_account),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            AgnelloTextField(
                value = nome,
                onValueChange = { nome = it },
                label = stringResource(R.string.complete_name),
                leadingIcon = Icons.Filled.Person
            )
            Spacer(Modifier.height(12.dp))
            AgnelloTextField(
                value = dataNascimento,
                onValueChange = { dataNascimento = it },
                label = stringResource(R.string.birth_date),
                placeholder = stringResource(R.string.birth_date_placeholder),
                leadingIcon = Icons.Filled.DateRange,
                keyboardType = KeyboardType.Number
            )
            Spacer(Modifier.height(12.dp))
            AgnelloTextField(
                value = email,
                onValueChange = { email = it },
                label = stringResource(R.string.your_email),
                leadingIcon = Icons.Filled.Email,
                keyboardType = KeyboardType.Email
            )
            Spacer(Modifier.height(12.dp))
            AgnelloPasswordField(
                value = senha,
                onValueChange = { senha = it },
                label = stringResource(R.string.your_password),
                showPasswordDescription = stringResource(R.string.content_desc_show_password),
                hidePasswordDescription = stringResource(R.string.content_desc_hide_password)
            )
            Spacer(Modifier.height(12.dp))
            AgnelloPasswordField(
                value = confirmarSenha,
                onValueChange = { confirmarSenha = it },
                label = stringResource(R.string.confirm_password),
                showPasswordDescription = stringResource(R.string.content_desc_show_password),
                hidePasswordDescription = stringResource(R.string.content_desc_hide_password)
            )
            Spacer(Modifier.height(20.dp))
            AgnelloPrimaryButton(
                text = stringResource(R.string.create_account),
                onClick = navigateToLogin
            )
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun SignupScreenPreview() {
    VinheriaagnelloTheme {
        SignupScreen(navigateToLogin = {})
    }
}
