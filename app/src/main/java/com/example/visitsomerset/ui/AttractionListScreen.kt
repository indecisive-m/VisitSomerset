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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visitsomerset.data.LocalAttractionsData
import com.example.visitsomerset.model.Attraction
import com.example.visitsomerset.ui.theme.PurpleGrey80
import com.example.visitsomerset.ui.theme.VisitSomersetTheme

@Composable
fun AttractionListScreen(
    attractionList: List<Attraction>,
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
            AttractionListItem(
                attraction
            )
        }
    }
}


@Composable
fun AttractionListItem(
    attraction: Attraction,
    modifier: Modifier = Modifier

) {

    val height = 180.dp

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(PurpleGrey80)
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
                    fontWeight = FontWeight.Bold

                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(attraction.description),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AttractionListScreenPreview() {
    VisitSomersetTheme {
        AttractionListScreen(LocalAttractionsData.getListOfAttractions())
    }
}

@Preview(showBackground = true)
@Composable
fun AttractionListItemPreview() {
    VisitSomersetTheme {
        AttractionListItem(LocalAttractionsData.firstAttraction)
    }
}