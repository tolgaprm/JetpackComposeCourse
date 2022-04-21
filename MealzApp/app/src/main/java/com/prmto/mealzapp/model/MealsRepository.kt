package com.prmto.mealzapp.model

import com.prmto.mealzapp.model.api.MealsWebService
import com.prmto.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals():MealsCategoriesResponse {
        return webService.getMeals()
    }
}