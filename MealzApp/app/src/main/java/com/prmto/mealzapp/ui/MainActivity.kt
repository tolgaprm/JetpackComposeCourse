package com.prmto.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.prmto.mealzapp.ui.details.MealDetailsScreen
import com.prmto.mealzapp.ui.details.MealDetailsViewModel
import com.prmto.mealzapp.ui.meals.MealsCategoriesScreen
import com.prmto.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                FoodiezApp()
            }
        }
    }
}


@Composable
fun FoodiezApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "meals_list") {

        composable("meals_list") {
            MealsCategoriesScreen(navController) { navigationId ->
                navController.navigate("meal_details/$navigationId")
            }
        }
        composable(
            "meal_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel:MealDetailsViewModel = viewModel()

            MealDetailsScreen(meal =viewModel.mealState.value)
        }
    }
}