package the.end2024.carrotclone.presentation.ex

import the.end2024.carrotclone.core.BaseViewModel
import the.end2024.carrotclone.core.UiEvent

class ExViewModel : BaseViewModel<ExContract.State, ExContract.Event, ExContract.Effect>() {
    override fun createState(): ExContract.State {
        return ExContract.State(count = 0)
    }

    override fun handleEvent(event: UiEvent) {
        when(event) {
            is ExContract.Event.IncreaseCount -> {
                setState { copy( count = count + 1) }
                sendEffect {
                    val message = "증가된 카운트는 ${ state.value.count }입니다."
                    ExContract.Effect.ShowToast(message)
                }
            }
        }
    }
}