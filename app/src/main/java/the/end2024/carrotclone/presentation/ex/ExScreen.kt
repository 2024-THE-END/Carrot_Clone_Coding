package the.end2024.carrotclone.presentation.ex

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import the.end2024.carrotclone.core.BaseScreen

class ExScreen(
    private val viewModel: ExViewModel
) : BaseScreen() {
    @Composable
    override fun Create() {
        Effect()

        val state = viewModel.state.collectAsStateWithLifecycle()
        val count = state.value.count

        Column {
            Text(
                text = count.toString()
            )
            Button(
                onClick = {
                    viewModel.sendEvent(ExContract.Event.IncreaseCount)
                }) {
                Text(text = "증가")
            }
        }
    }

    @Composable
    override fun Effect() {
        val context = LocalContext.current
        LaunchedEffect(viewModel.effect) {
            viewModel.effect.onEach { effect ->
                when(effect) {
                    is ExContract.Effect.ShowToast -> {
                        Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }.collect()
        }
    }

}