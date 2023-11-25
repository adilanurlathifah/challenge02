package org.adilanur.challenge02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT))


        navController = findNavController(R.id.nav_host)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (
                destination.id == R.id.homeFragment ||
                destination.id == R.id.keranjangFragment ||
                destination.id == R.id.profileFragment
                ) {
                binding.navBottom.setupWithNavController(navController)
                binding.navBottom.visibility = View.VISIBLE

            } else {
                binding.navBottom.visibility = View.GONE
            }
        }
    }
}