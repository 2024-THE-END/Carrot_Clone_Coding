package the.end2024.carrotclone.presentation.ex

import the.end2024.carrotclone.core.UiEffect
import the.end2024.carrotclone.core.UiEvent
import the.end2024.carrotclone.core.UiState

class ExContract {

    data class State(
        val count: Int
    ) : UiState

    sealed class Event : UiEvent {
        object IncreaseCount : Event()
    }

    sealed class Effect : UiEffect {
        data class ShowToast(val message: String) : Effect()
    }
}