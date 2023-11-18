package org.adilanur.challenge02.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import org.adilanur.challenge02.model.Cart

@Dao
interface CartDao {
    @Insert
    fun insert(cart: Cart)

    @Query("SELECT * FROM tbl_cart ORDER BY itemId DESC")
    fun getAllItem(): LiveData<List<Cart>>

    @Query("DELETE FROM tbl_cart")
    fun clearData()

    @Query("DELETE FROM tbl_cart WHERE itemId = :itemIdParams")
    fun delteByItemId(itemIdParams: Long)

    @Update
    fun update(cart: Cart)
}