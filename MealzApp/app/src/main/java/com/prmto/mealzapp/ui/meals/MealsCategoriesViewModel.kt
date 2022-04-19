package com.prmto.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.prmto.mealzapp.model.MealsRepository
import com.prmto.mealzapp.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    fun getMeal(successCallback: (response: MealsCategoriesResponse?) -> Unit) {

        return repository.getMeals() { response ->
            successCallback(response)
        }
    }

}