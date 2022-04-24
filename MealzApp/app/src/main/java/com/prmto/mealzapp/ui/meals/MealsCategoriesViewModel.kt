package com.prmto.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prmto.mealzapp.model.MealsRepository
import com.prmto.mealzapp.model.response.MealsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel() :
    ViewModel() {
    private val repository: MealsRepository = MealsRepository.getInstance()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            meals.value = getMeal()
        }
    }

    val meals: MutableState<List<MealsResponse>> = mutableStateOf(emptyList())

    suspend fun getMeal(): List<MealsResponse> {
        return repository.getMeals().categories
    }

}