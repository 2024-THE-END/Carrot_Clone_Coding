package the.end2024.carrotclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel
import the.end2024.carrotclone.presentation.ex.ExScreen
import the.end2024.carrotclone.presentation.nav.NavigationManager
import the.end2024.carrotclone.presentation.theme.CarrotCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarrotCloneTheme {
                //ExScreen(koinViewModel()).Create()
                NavigationManager.addNavigation()
            }
        }
    }
}