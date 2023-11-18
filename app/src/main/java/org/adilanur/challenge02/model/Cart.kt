package org.adilanur.challenge02.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "tbl_cart")
data class Cart(
    @PrimaryKey(autoGenerate = true)
    var itemId: Long? = null,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "price")
    var price:Int,
    @ColumnInfo(name = "quantity")
    var quantity: Int,
    @ColumnInfo(name = "img")
    var img: Int,

    )
{
    companion object {
        const val TABLE_NAME = "tbl_cart"
    }
}