package com.example.visitsomerset.ui

import androidx.lifecycle.ViewModel
import com.example.visitsomerset.data.LocalAttractionsData
import com.example.visitsomerset.model.Attraction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AttractionViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(
        AttractionUiState(
            attractionList = LocalAttractionsData.getListOfAttractions()
        )
    )

    val uiState: StateFlow<AttractionUiState> = _uiState
}

