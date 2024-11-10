package com.example.visitsomerset.ui

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.visitsomerset.model.Attraction
import com.example.visitsomerset.ui.theme.Purple40
import com.example.visitsomerset.ui.theme.Purple80
import com.example.visitsomerset.utils.AttractionLayout


@Composable
fun AttractionList(
    attractionList: List<Attraction>,
    focussedAttraction: Attraction,
    contentLayout: AttractionLayout,
    modifier: Modifier = Modifier
) {
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

            if (contentLayout == AttractionLayout.HORIZONTAL) {
                AttractionListItemLargeScreens(
                    attraction = attraction,
                    focussedAttraction = focussedAttraction,
                    onClick = {},
                )
            } else {
                AttractionListItemSmallScreens(
                    attraction = attraction,
                    focussedAttraction = focussedAttraction,
                    onClick = {},
                )

            }
        }
    }
}


@Composable
fun AttractionListItemSmallScreens(
    attraction: Attraction,
    modifier: Modifier = Modifier,
    focussedAttraction: Attraction,
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
                .background(if (attraction == focussedAttraction) Purple40 else Purple80)
        ) {
            Image(
                painter = painterResource(attraction.img),
                contentDescription = stringResource(attraction.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(height)
                    .width(height)
                    .weight(1f)
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
                    color = if (attraction == focussedAttraction) Color.White else Color.Black
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(attraction.description),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = if (attraction == focussedAttraction) Color.White else Color.Black

                )
            }
        }
    }
}

@Composable
fun AttractionListItemLargeScreens(
    attraction: Attraction,
    focussedAttraction: Attraction,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val height = 180.dp
    
    Card(modifier = modifier) {
        Column(modifier = modifier.fillMaxSize()) {
            Image(
                painter = painterResource(attraction.img),
                contentDescription = stringResource(attraction.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(height)
                    .width(height)
                    .weight(1f)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(attraction.name),
                style = MaterialTheme.typography.titleLarge,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                color = if (attraction == focussedAttraction) Color.White else Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(attraction.description),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = if (attraction == focussedAttraction) Color.White else Color.Black

            )
        }
    }
}

@Composable
fun AttractionDetails(
    focussedAttraction: Attraction,
    isListView: Boolean,
    modifier: Modifier = Modifier
) {

    return if (isListView) {
        AttractionDetailsSmallScreens(
            focussedAttraction = focussedAttraction,
            modifier = modifier
        )
    } else {
        AttractionDetailsLargeScreens(
            focussedAttraction = focussedAttraction,
            modifier = modifier
        )
    }

}

@Composable
fun AttractionDetailsLargeScreens(
    focussedAttraction: Attraction,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(focussedAttraction.img),
            contentDescription = stringResource(focussedAttraction.name),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.weight(1f)
        )
        Spacer(Modifier.height(12.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(focussedAttraction.name),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = stringResource(focussedAttraction.description),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 8.dp)

            )

        }
    }
}

@Composable
fun AttractionDetailsSmallScreens(
    focussedAttraction: Attraction,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(focussedAttraction.img),
            contentDescription = stringResource(focussedAttraction.name),
            contentScale = ContentScale.Inside
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = stringResource(focussedAttraction.name),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(focussedAttraction.description),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 8.dp)

        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AttractionListScreenPreview() {
//    VisitSomersetTheme {
//        AttractionList(
//            LocalAttractionsData.getListOfAttractions(),
//            focussedAttraction = LocalAttractionsData.firstAttraction
//        )
//    }
//}
//

//@Preview(showBackground = true)
//@Composable
//fun AttractionListItemPreview() {
//    VisitSomersetTheme {
//        AttractionListItem(
//            LocalAttractionsData.firstAttraction,
//            focussedAttraction = LocalAttractionsData.firstAttraction,
//            onClick = {})
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun AttractionDetailsPreview() {
//    VisitSomersetTheme {
//        AttractionDetails(
//            LocalAttractionsData.firstAttraction,
//            isListView = true
//        )
//    }
//}