package br.com.mftech.vinheria_agnello.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import br.com.mftech.vinheria_agnello.ui.theme.Gold
import br.com.mftech.vinheria_agnello.ui.theme.VinheriaagnelloTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navigateToHome: () -> Unit, navigateToSignup: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AgnelloTopAppBar(title = stringResource(R.string.app_name))
        },
        bottomBar = {
            AgnelloBottomMessageBar(
                message = stringResource(R.string.dont_have_an_account),
                actionLabel = stringResource(R.string.signup),
                onActionClick = navigateToSignup
            )
        },
        floatingActionButton = {
            AgnelloFab(
                icon = Icons.AutoMirrored.Filled.Login,
                contentDescription = stringResource(R.string.login),
                onClick = navigateToHome
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.wineloginpage),
                contentDescription = stringResource(R.string.content_desc_wine_login_logo),
                modifier = Modifier.size(130.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
                color = Gold,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                stringResource(R.string.login_to_continue_your_experience),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
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
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(64.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    stringResource(R.string.remember_next_time),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                        checkedTrackColor = MaterialTheme.colorScheme.primary,
                        uncheckedThumbColor = MaterialTheme.colorScheme.primary,
                        uncheckedTrackColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
            Spacer(Modifier.height(8.dp))
            AgnelloPrimaryButton(
                text = stringResource(R.string.login),
                onClick = navigateToHome
            )
            Spacer(Modifier.height(16.dp))
            TextButton(onClick = { /* recuperação de senha: fora do escopo deste protótipo */ }) {
                Text(
                    stringResource(R.string.forgot_my_password),
                    color = Gold
                )
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    VinheriaagnelloTheme {
        LoginScreen(navigateToHome = {}, navigateToSignup = {})
    }
}
