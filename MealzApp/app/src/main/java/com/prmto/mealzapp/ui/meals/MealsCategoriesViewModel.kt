package com.prmto.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.prmto.mealzapp.model.MealsRepository
import com.prmto.mealzapp.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    suspend fun getMeal(): List<MealsResponse> {
        return repository.getMeals().categories
    }

}