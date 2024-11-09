package com.example.visitsomerset.ui

import com.example.visitsomerset.data.LocalAttractionsData
import com.example.visitsomerset.model.Attraction

data class AttractionUiState(
    val attractionList: List<Attraction> = emptyList(),
    val focussedAttraction: Attraction = LocalAttractionsData.firstAttraction,
    val isListPageShown: Boolean = true

)
