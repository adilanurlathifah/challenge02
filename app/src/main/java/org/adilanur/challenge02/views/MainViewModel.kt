package org.adilanur.challenge02.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.adilanur.challenge02.model.Chart

class MainViewModel : ViewModel() {
    val vCounter: MutableLiveData<Int> = MutableLiveData(0)


    val _chartData = MutableLiveData<Chart>()
    val chartData: LiveData<Chart>
        get() = _chartData

    fun incrementCount() {
        vCounter.postValue(vCounter.value?.plus(1))
    }

    fun decrementCount() {
        vCounter.value?.let {
            if (it > 0) {
                vCounter.postValue(vCounter.value?.minus(1))
            }
        }
    }
}
