package org.adilanur.challenge02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import org.adilanur.challenge02.databinding.ActivityMainBinding


@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav()

    }

    private fun setupBottomNav() {
        binding.apply {
            navController = findNavController(R.id.nav_host_fragment_activity_main)

            navController.addOnDestinationChangedListener { _, destination, _ ->
                if (destination.id == R.id.homeFragment || destination.id == R.id.keranjangFragment || destination.id == R.id.profileFragment) {
                    binding.bottomNavView.setupWithNavController(navController)
                    binding.bottomNavView.visibility = View.VISIBLE

                } else {
                    binding.bottomNavView.visibility = View.GONE
                }
            }
        }
    }
}