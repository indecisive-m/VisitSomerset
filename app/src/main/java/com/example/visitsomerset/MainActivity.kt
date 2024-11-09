package com.example.visitsomerset

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visitsomerset.ui.AttractionDetails
import com.example.visitsomerset.ui.AttractionViewModel
import com.example.visitsomerset.ui.theme.VisitSomersetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitSomersetTheme {

                val viewModel: AttractionViewModel = viewModel()
                val uiState by viewModel.uiState.collectAsState()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()

                ) { innerPadding ->
//                    AttractionListScreen(
//                        attractionList = uiState.attractionList,
//                        focussedAttraction = uiState.focussedAttraction,
//                        modifier = Modifier
//                            .padding(innerPadding)
//                    )
                    AttractionDetails(
                        focussedAttraction = uiState.focussedAttraction,
                        modifier = Modifier.padding(innerPadding),
                        isListView = false
                    )

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VisitSomersetTheme {

    }
}