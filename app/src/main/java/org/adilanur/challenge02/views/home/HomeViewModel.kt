package org.adilanur.challenge02.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.adilanur.challenge02.model.CategoryResponse
import org.adilanur.challenge02.service.ApiRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {
    val loadingState = MutableLiveData<Boolean>()
    val errorState = MutableLiveData<Pair<Boolean, Exception?>>()
    var isError = MutableLiveData<Boolean>()


    val _getListCategory = MutableLiveData<CategoryResponse?>()

    val getListCategory: LiveData<CategoryResponse?>
        get() = _getListCategory

    fun getCategory() {
        loadingState.postValue(true)
        errorState.postValue(Pair(false,null))
        apiRepository.getListCategory().enqueue(
            object : Callback<CategoryResponse> {
                override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                    viewModelScope.launch {
                        loadingState.postValue(false)
                        errorState.postValue(Pair(false, null))
                    }
                }
                override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {

                    viewModelScope.launch {
                        if (response.code() == 400|| response.code() == 401||response.code()==500) {
                            isError.postValue(true)
                        } else {
                            isError.postValue(false)
                            _getListCategory.postValue(response.body())

                        }
                        loadingState.postValue(false)
                        errorState.postValue(Pair(false, null))
                    }
                }
            }
        )
    }
}