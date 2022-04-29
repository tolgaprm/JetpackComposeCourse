package com.prmto.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.prmto.mealzapp.model.response.MealsResponse
import kotlin.math.max
import kotlin.math.min


@Composable
fun MealDetailsScreen(meal: MealsResponse?) {

    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value / 600f))
    val size by animateDpAsState(targetValue =max(100.dp, 200.dp * offset) )
    
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Surface(elevation = 8.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Color.Green)
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(meal?.imageUrl)
                                .transformations(CircleCropTransformation())
                                .build(),
                            contentDescription = "",
                            modifier = Modifier
                                .size(size)
                                .padding(8.dp)
                        )
                    }
                    Text(
                        text = meal?.name ?: "default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                repeat(20) {
                    Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                }
            }
        }
    }

}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Blue, 120.dp, 8.dp),
    Expanded(Color.Cyan, 200.dp, 24.dp)
}