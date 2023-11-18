package org.adilanur.challenge02.views.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.adilanur.challenge02.model.Foods

class DetailViewModel : ViewModel() {
    private val _counter: MutableLiveData<Int> = MutableLiveData(0)
    val counterLiveData: LiveData<Int> get() = _counter

    private val _totalPrice = MutableLiveData<Int>()
    val totalPriceLiveData: LiveData<Int> = _totalPrice

    private val _selectedItem = MutableLiveData<Foods>()
    val selectedItemLiveData: LiveData<Foods> = _selectedItem

    fun initSelectedItem(item: Foods) {
        _selectedItem.value = item
        _totalPrice.value = item.price
    }

    fun incrementCount() {
        _counter.value = _counter.value?.plus(1)
        updateTotalPrice()
    }

    fun decrementCount() {
        _counter.value?.let {
            if (it > 0) {
                _counter.value = _counter.value?.minus(1)
                updateTotalPrice()
            }
        }
    }

    private fun calculateTotalPrice(currentAmount: Int, selectedItem: Foods?): Int {
        return selectedItem?.price?.times(currentAmount) ?: 0
    }

    fun updateTotalPrice() {
        val currentAmount = _counter.value ?: 1
        val selectedItem = _selectedItem.value
        if (selectedItem != null) {
            val totalPrice = selectedItem.price * currentAmount
            _totalPrice.value = totalPrice
        }
    }
}