package br.com.mftech.vinheria_agnello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.mftech.vinheria_agnello.ui.theme.VinheriaagnelloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VinheriaagnelloTheme {
                NavigationWrapper()
            }
        }
    }
}
