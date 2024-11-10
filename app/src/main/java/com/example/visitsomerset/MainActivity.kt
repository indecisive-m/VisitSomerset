package com.example.visitsomerset

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.visitsomerset.ui.AttractionList
import com.example.visitsomerset.ui.AttractionViewModel
import com.example.visitsomerset.ui.theme.VisitSomersetTheme
import com.example.visitsomerset.utils.AttractionLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitSomersetTheme {

                val viewModel: AttractionViewModel = viewModel()
                val uiState by viewModel.uiState.collectAsState()

                val windowSize: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

                var contentLayout: AttractionLayout

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()

                ) { innerPadding ->


                    contentLayout = when (windowSize.windowWidthSizeClass) {
                        WindowWidthSizeClass.EXPANDED ->
                            AttractionLayout.HORIZONTAL

                        else -> AttractionLayout.VERTICAL
                    }

                    AttractionList(
                        attractionList = uiState.attractionList,
                        focussedAttraction = uiState.focussedAttraction,
                        modifier = Modifier.padding(innerPadding),
                        contentLayout = contentLayout
                    )

//                    if (contentLayout == AttractionLayout.HORIZONTAL) {
////                        AttractionDetails(
////                            focussedAttraction = uiState.focussedAttraction,
////                            modifier = Modifier.padding(innerPadding),
////                            isListView = false
////                        )
//                        AttractionList(
//                            attractionList = uiState.attractionList,
//                            focussedAttraction = uiState.focussedAttraction,
//                            modifier = Modifier.padding(innerPadding),
//                            contentLayout = contentLayout
//                        )
//                    } else {
//                        AttractionDetails(
//                            focussedAttraction = uiState.focussedAttraction,
//                            modifier = Modifier.padding(innerPadding),
//                            isListView = true
//                        )
//                        AttractionListScreen(
//                            attractionList = uiState.attractionList,
//                            focussedAttraction = uiState.focussedAttraction,
//                            modifier = Modifier
//                                .padding(innerPadding)
//                        )

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