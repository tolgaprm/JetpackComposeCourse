package com.prmto.mealzapp.model.api

import com.prmto.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class MealsWebService {
    private lateinit var mealsApi: MealsApi
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mealsApi = retrofit.create(MealsApi::class.java)
    }


    suspend fun getMeals(): MealsCategoriesResponse{
        return mealsApi.getMeals()
    }

}

interface MealsApi {

    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse
}