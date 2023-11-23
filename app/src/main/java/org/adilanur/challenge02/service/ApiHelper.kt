package org.adilanur.challenge02.service

import javax.inject.Inject

class ApiHelper @Inject constructor(private val api: ApiService) {
    fun getCategories() = api.getCategories()
    fun getMenu() = api.getMenu()

}