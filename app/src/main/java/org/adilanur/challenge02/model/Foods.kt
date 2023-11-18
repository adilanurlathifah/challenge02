package org.adilanur.challenge02.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Foods(
    var price: Int,
    var desc: String,
    var name: String,
    var img: Int,

    ) : Parcelable
