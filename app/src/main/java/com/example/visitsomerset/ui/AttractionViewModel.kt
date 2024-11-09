package com.example.visitsomerset.ui

import androidx.lifecycle.ViewModel
import com.example.visitsomerset.data.LocalAttractionsData
import com.example.visitsomerset.model.Attraction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AttractionViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(
        AttractionUiState(
            attractionList = LocalAttractionsData.getListOfAttractions(),
            focussedAttraction = LocalAttractionsData.firstAttraction
        )
    )

    val uiState: StateFlow<AttractionUiState> = _uiState


    fun navigateToAttractionPage() {
        _uiState.update {
            it.copy(isListPageShown = false)
        }
    }

    fun selectFocussedAttraction(attraction: Attraction) {
        _uiState.update {
            it.copy(focussedAttraction = attraction)
        }
    }


}

