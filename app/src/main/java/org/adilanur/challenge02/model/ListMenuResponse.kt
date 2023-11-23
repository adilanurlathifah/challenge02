package org.adilanur.challenge02.model

data class ListMenuResponse(
    val code: Int,
    val `data`: List<ListMenu>,
    val message: String,
    val status: Boolean
)