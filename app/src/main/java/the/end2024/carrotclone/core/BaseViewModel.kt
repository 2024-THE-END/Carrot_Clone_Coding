package the.end2024.carrotclone.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


abstract class BaseViewModel<State : UiState, Event : UiEvent, Effect : UiEffect> : ViewModel() {

    private val _state: MutableStateFlow<State> by lazy {
        MutableStateFlow(createState())
    }

    val state: StateFlow<UiState> by lazy {
        _state.asStateFlow()
    }

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event: SharedFlow<Event> = _event.asSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect: Flow<Effect> = _effect.receiveAsFlow()

    init {
        subscribeEvent()
    }

    abstract fun createState() : State

    abstract fun handleEvent(event: UiEvent)

    private fun subscribeEvent() {
        viewModelScope.launch {
            _event.collect {
                handleEvent(it)
            }
        }
    }

    protected fun sendEffect(effect: () -> Effect) {
        val effectValue = effect()
        viewModelScope.launch { _effect.send(effectValue) }
    }

    fun sendEvent(event: Event) {
        viewModelScope.launch { _event.emit(event) }
    }

    protected fun setState(reduce: State.() -> State) {
        val newState = _state.value.reduce()
        _state.value = newState
    }

}

interface UiState

interface UiEvent

interface UiEffect