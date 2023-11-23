package org.adilanur.challenge02.service

import javax.inject.Inject


class ApiRepository @Inject constructor(private val apiHelper: ApiHelper) {

    fun getListCategory() = apiHelper.getCategories()

}