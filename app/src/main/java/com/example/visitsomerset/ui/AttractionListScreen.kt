package com.example.visitsomerset.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.visitsomerset.R
import com.example.visitsomerset.data.LocalAttractionsData
import com.example.visitsomerset.model.Attraction
import com.example.visitsomerset.ui.theme.Purple80
import com.example.visitsomerset.ui.theme.VisitSomersetTheme
import com.example.visitsomerset.utils.AttractionLayout


enum class AttractionAppScreen(
    @StringRes
    val title: Int
) {
    Start(R.string.app_name),
    Details(R.string.app_name)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttractionApp(
    viewModel: AttractionViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()

    val windowSize: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    var contentLayout: AttractionLayout


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = Purple80,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.displaySmall,
                        color = Color.Black

                    )
                },
            )
        },
        modifier = Modifier
            .fillMaxSize()

    ) { innerPadding ->
        contentLayout = when (windowSize.windowWidthSizeClass) {
            WindowWidthSizeClass.EXPANDED ->
                AttractionLayout.HORIZONTAL

            else -> AttractionLayout.VERTICAL
        }


        NavHost(
            navController = navController,
            startDestination = AttractionAppScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AttractionAppScreen.Start.name) {
                AttractionList(
                    attractionList = uiState.attractionList,
                    focussedAttraction = uiState.focussedAttraction,
                    modifier = Modifier,
                    contentLayout = contentLayout,
                    viewModel = viewModel,
                    onClick = {

                        navController.navigate(AttractionAppScreen.Details.name)
                    }

                )
            }
            composable(AttractionAppScreen.Details.name) {
                AttractionDetails(
                    focussedAttraction = uiState.focussedAttraction,
                    contentLayout = contentLayout,
                    modifier = Modifier
                )
            }
        }

    }
}

@Composable
fun AttractionList(
    attractionList: List<Attraction>,
    focussedAttraction: Attraction,
    contentLayout: AttractionLayout,
    viewModel: AttractionViewModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    if (contentLayout == AttractionLayout.VERTICAL) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    horizontal = 12.dp,
                    vertical = 12.dp
                ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(attractionList) { attraction ->
                AttractionListItemSmallScreens(
                    attraction = attraction,
                    onClick = {
                        viewModel.selectFocussedAttraction(attraction)
                        onClick()

                    },
                )
            }
        }
    } else {
        LazyVerticalStaggeredGrid(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    horizontal = 12.dp,
                    vertical = 12.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalItemSpacing = 12.dp,
            columns = StaggeredGridCells.Fixed(2)
        ) {
            items(attractionList) { attraction ->

                AttractionListItemLargeScreens(
                    attraction = attraction,
                    onClick = {
                        viewModel.selectFocussedAttraction(attraction)
                        onClick()
                    },
                )

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    focussedAttraction: Attraction
) {
    CenterAlignedTopAppBar(
        colors = topAppBarColors(
            containerColor = Purple80,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displaySmall,
                color = Color.Black

            )
        },
    )
}

@Composable
fun AttractionListItemSmallScreens(
    attraction: Attraction,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val height = 180.dp

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Purple80)
        ) {
            Image(
                painter = painterResource(attraction.img),
                contentDescription = stringResource(attraction.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
                    .height(height)
                    .width(height)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .weight(2f)
                    .height(height),
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = stringResource(attraction.name),
                    style = MaterialTheme.typography.titleLarge,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(attraction.description),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black

                )
            }
        }
    }
}

@Composable
fun AttractionListItemLargeScreens(
    attraction: Attraction,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val height = 300.dp

    Card(modifier = modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Purple80)
        ) {
            Image(
                painter = painterResource(attraction.img),
                contentDescription = stringResource(attraction.name),
                contentScale = ContentScale.Inside,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(attraction.name),
                style = MaterialTheme.typography.titleLarge,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = stringResource(attraction.description),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge


            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun AttractionListScreenPreview() {
//    VisitSomersetTheme {
//        AttractionList(
//            LocalAttractionsData.getListOfAttractions(),
//            focussedAttraction = LocalAttractionsData.firstAttraction,
//            contentLayout = AttractionLayout.VERTICAL,
//            viewModel: AttractionViewModel = viewModel(),
//        )
//    }
//}


@Preview(showBackground = true)
@Composable
fun AttractionListItemPreview() {
    VisitSomersetTheme {
        AttractionListItemLargeScreens(
            LocalAttractionsData.firstAttraction,
            onClick = {}
        )
    }
}



