package org.adilanur.challenge02.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class ListMenu(
    val alamat_resto: String,
    val detail: String,
    val harga: Int,
    val harga_format: String,
    val image_url: String,
    val nama: String
): Parcelable {

}