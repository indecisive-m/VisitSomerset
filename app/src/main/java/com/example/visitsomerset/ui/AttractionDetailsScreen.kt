package com.example.visitsomerset.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visitsomerset.data.LocalAttractionsData
import com.example.visitsomerset.model.Attraction
import com.example.visitsomerset.ui.theme.VisitSomersetTheme
import com.example.visitsomerset.utils.AttractionLayout


@Composable
fun AttractionDetails(
    focussedAttraction: Attraction,
    contentLayout: AttractionLayout,
    modifier: Modifier = Modifier
) {

    return if (contentLayout === AttractionLayout.VERTICAL) {
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


@Preview(showBackground = true)
@Composable
fun AttractionDetailsPreview() {
    VisitSomersetTheme {
        AttractionDetails(
            LocalAttractionsData.firstAttraction,
            AttractionLayout.VERTICAL
        )
    }
}