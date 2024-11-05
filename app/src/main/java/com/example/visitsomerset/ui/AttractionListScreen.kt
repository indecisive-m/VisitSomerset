package com.example.visitsomerset.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visitsomerset.data.LocalAttractionsData
import com.example.visitsomerset.model.Attraction
import com.example.visitsomerset.ui.theme.VisitSomersetTheme

@Composable
fun AttractionListScreen(
    attraction: List<Attraction>,
    modifier: Modifier = Modifier
) {

}

@Composable
fun AttractionListItem(
    attraction: Attraction,
    modifier: Modifier = Modifier

) {
    Row(){
        Image(
            painter = painterResource(attraction.img),
            contentDescription = stringResource(attraction.name),
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(200.dp).width(200.dp)
        )
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