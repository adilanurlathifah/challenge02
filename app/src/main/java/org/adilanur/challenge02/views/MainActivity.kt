package org.adilanur.challenge02.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import org.adilanur.challenge02.R
import org.adilanur.challenge02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment || destination.id == R.id.profileFragment || destination.id == R.id.keranjangFragment) {
                binding.bottomNav.setupWithNavController(navController)
                binding.bottomNav.visibility = View.VISIBLE

            } else {
                binding.bottomNav.visibility = View.GONE
            }
        }
    }
}