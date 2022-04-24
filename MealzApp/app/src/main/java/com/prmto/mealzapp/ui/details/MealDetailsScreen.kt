package com.prmto.mealzapp.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.prmto.mealzapp.model.response.MealsResponse


@Composable
fun MealDetailsScreen(meal: MealsResponse?) {
    Column {
        Row {
            Card {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(meal?.imageUrl)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = "",
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(meal?.name ?: "default name")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Change state of meal profile picture")
        }
    }
}