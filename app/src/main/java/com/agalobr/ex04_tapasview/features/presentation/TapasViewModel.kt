package com.agalobr.ex04_tapasview.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agalobr.ex04_tapasview.app.ErrorApp
import com.agalobr.ex04_tapasview.features.domain.GetTapasUseCase
import com.agalobr.ex04_tapasview.features.domain.Tapas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TapasViewModel(private val getTapasUseCase: GetTapasUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadTapas() {
        viewModelScope.launch(Dispatchers.IO) {
            getTapasUseCase.invoke().fold(
                { responseError(it) },
                { responseLoadTapasSuccess(it) }
            )
        }
    }

    private fun responseError(it: ErrorApp) {
        _uiState.postValue(UiState(errorApp = it))
    }

    private fun responseLoadTapasSuccess(it : List<Tapas>) {
        _uiState.postValue(UiState(listTapas = it))
    }

    data class UiState(
        val errorApp: ErrorApp? = null,
        val isLoading: Boolean = false,
        val listTapas: List<Tapas> = emptyList()
    )
}