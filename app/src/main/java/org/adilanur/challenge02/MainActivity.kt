package org.adilanur.challenge02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "Jumlah data: " + getData().size)
    }

    private fun getData(): List<Menu> {
        return listOf(
            Menu("Ayam Goreng", 12000, R.drawable.fried_chicken)
        )

    }
}