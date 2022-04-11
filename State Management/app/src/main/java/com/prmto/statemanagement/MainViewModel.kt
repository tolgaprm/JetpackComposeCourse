package com.prmto.statemanagement

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val textFieldState = MutableLiveData("")

    fun onTextChanged(newName: String) {
        textFieldState.value = newName
    }


}