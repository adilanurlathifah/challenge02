package org.adilanur.challenge02.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.adilanur.challenge02.data.dao.CartDao
import org.adilanur.challenge02.model.Cart

@Database(entities = [Cart::class], version = 1, exportSchema = false)
abstract class Appdatabase : RoomDatabase() {

    abstract val dao: CartDao

    companion object {

        @Volatile
        private var INSTANCE: Appdatabase? = null

        fun getInstance(context: Context): Appdatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Appdatabase::class.java,
                        "db_food"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}