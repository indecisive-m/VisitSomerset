package com.example.visitsomerset

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.visitsomerset.data.LocalAttractionsData
import com.example.visitsomerset.ui.AttractionListScreen
import com.example.visitsomerset.ui.theme.VisitSomersetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitSomersetTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()

                ) { innerPadding ->
                    AttractionListScreen(
                        attractionList = LocalAttractionsData.getListOfAttractions(),
                        modifier = Modifier
                            .padding(innerPadding)
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