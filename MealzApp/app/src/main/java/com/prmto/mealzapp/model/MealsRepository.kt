package com.prmto.mealzapp.model

import com.prmto.mealzapp.model.api.MealsWebService
import com.prmto.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(): MealsCategoriesResponse? {
        return webService.getMeals().execute().body() // Bad Practice
    }
}