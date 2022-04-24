package com.prmto.mealzapp.model

import com.prmto.mealzapp.model.api.MealsWebService
import com.prmto.mealzapp.model.response.MealsCategoriesResponse
import com.prmto.mealzapp.model.response.MealsResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    private var cachedMeals = listOf<MealsResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response

    }

    fun getMeal(id: String): MealsResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MealsRepository(MealsWebService()).also { instance = it }
        }
    }
}