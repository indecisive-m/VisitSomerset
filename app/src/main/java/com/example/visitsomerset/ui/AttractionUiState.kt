package com.example.visitsomerset.ui

import com.example.visitsomerset.model.Attraction

data class AttractionUiState(
    val attractionList: List<Attraction> = emptyList()
)
