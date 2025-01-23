package com.example.dicerrollerapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DiceViewModel : ViewModel() {

    private val _diceState = MutableStateFlow(DiceState())
    val diceState: StateFlow<DiceState> get() = _diceState

    fun rollDice() {
        _diceState.update { state ->
            val newResult = (1..6).random()
            state.copy(
                pendingResult = newResult,
                isRolling = true
            )
        }

        // Simulate the dice roll completion
        kotlinx.coroutines.GlobalScope.launch {
            kotlinx.coroutines.delay(500) // Match animation duration
            _diceState.update { state ->
                state.copy(
                    result = state.pendingResult,
                    isRolling = false
                )
            }
        }
    }
}

data class DiceState(
    val result: Int = 1,
    val isRolling: Boolean = false,
    val pendingResult: Int = 1
)
