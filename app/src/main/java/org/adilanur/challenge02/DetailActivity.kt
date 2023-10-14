package org.adilanur.challenge02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var btnLocation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnLocation = findViewById(R.id.btn_location)

        btnLocation.setOnClickListener {
            val uri = Uri.parse("geo:-6.301215225215278, 106.65348182184478")
            val locationIntent = Intent(Intent.ACTION_VIEW, uri)

            locationIntent.setPackage("com.google.android.apps.maps")

            if (locationIntent.resolveActivity(packageManager) != null) {
                startActivity(locationIntent)
            } else {
                Toast.makeText(this, "Google Map Tidak Terinstall!", Toast.LENGTH_SHORT).show()
            }
        }

        val menuName = intent.getStringExtra("menuName")
        val menuDetail = intent.getStringExtra("menuDetail")
        val menuPrice = intent.getIntExtra("menuPrice", 0)
        val menuImg = intent.getIntExtra("menuImg", R.drawable.default_img)

        val nameTextView = findViewById<TextView>(R.id.menu_title)
        val descriptionTextView = findViewById<TextView>(R.id.menu_info)
        val priceTextView = findViewById<TextView>(R.id.menu_price)
        val imgView = findViewById<ImageView>(R.id.menu_image)

        nameTextView.text = menuName
        descriptionTextView.text = menuDetail
        priceTextView.text = "Rp. $menuPrice"
        imgView.setImageResource(menuImg)

    }
}