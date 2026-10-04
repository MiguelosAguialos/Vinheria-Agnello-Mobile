package br.com.mftech.vinheria_agnello

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import br.com.mftech.vinheria_agnello.screen.HomeScreen
import br.com.mftech.vinheria_agnello.screen.LoginScreen
import br.com.mftech.vinheria_agnello.screen.SignupScreen
import kotlinx.serialization.Serializable

@Serializable
data object Home: NavKey
@Serializable
data object Login: NavKey
@Serializable
data object Signup: NavKey
@Serializable
data object Error: NavKey

@Composable
fun NavigationWrapper(){
    // O app sempre começa no Login: é a porta de entrada do fluxo de autenticação.
    val backStack = rememberNavBackStack(Login)

    // Volta para a tela se ela ja estiver na pilha; caso contrario, empilha
    fun navigateTo(key: NavKey) {
        val index = backStack.lastIndexOf(key)
        if (index >= 0) {
            while (backStack.size > index + 1) backStack.removeAt(backStack.lastIndex)
        } else {
            backStack.add(key)
        }
    }

    // Usado só no login bem-sucedido: esvazia a pilha inteira (Login, Signup,
    // o que mais tiver) e deixa só a Home. Sem isso, apertar "voltar" na Home
    // levaria de volta pro Login, o que não faz sentido depois de autenticado.
    fun navigateToHomeAfterLogin() {
        backStack.clear()
        backStack.add(Home)
    }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull()},
        entryProvider = { key ->
            when(key){
                is Home -> NavEntry(key){
                    HomeScreen()
                }
                is Login -> NavEntry(key){
                    LoginScreen(
                        navigateToHome = { navigateToHomeAfterLogin() },
                        navigateToSignup = { navigateTo(Signup) }
                    )
                }
                is Signup -> NavEntry(key){
                    SignupScreen(
                        navigateToLogin = { navigateTo(Login) }
                    )
                }
                else -> NavEntry(key = Error){
                    Text("Error :(")
                }
            }
        }
    )
}
