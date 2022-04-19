package com.prmto.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prmto.mealzapp.model.response.MealsResponse
import com.prmto.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                MealsCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val rememberedMeal: MutableState<List<MealsResponse>> = remember {
        mutableStateOf(emptyList())
    }

    val viewModel: MealsCategoriesViewModel = viewModel()
    viewModel.getMeal() {
        val mealsFromTheApi = it?.categories
        rememberedMeal.value = mealsFromTheApi.orEmpty()
    }

    LazyColumn {
        items(rememberedMeal.value) { meal ->
            Text(text = meal.name)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}