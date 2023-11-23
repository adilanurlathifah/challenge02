package org.adilanur.challenge02.service

import org.adilanur.challenge02.model.CategoryResponse
import org.adilanur.challenge02.model.ListMenuResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("category")
    fun getCategories() : Call<CategoryResponse>

    @GET("listmenu")
    fun getMenu() : Call<ListMenuResponse>
}