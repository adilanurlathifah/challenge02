package org.adilanur.challenge02.views.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val isGrid = MutableLiveData<Boolean>().apply {
        value = true
    }
}