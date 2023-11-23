package org.adilanur.challenge02.model

data class CategoryResponse(
    val code: Int,
    val `data`: List<Category>,
    val message: String,
    val status: Boolean
)