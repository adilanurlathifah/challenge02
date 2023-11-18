package org.adilanur.challenge02.views.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.adilanur.challenge02.R
import org.adilanur.challenge02.adapter.MenuAdapter
import org.adilanur.challenge02.databinding.FragmentHomeBinding
import org.adilanur.challenge02.datasource.Menu
import org.adilanur.challenge02.sharedpref.SharedPreference


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var sharedPreference: SharedPreference
    private val foodlist = Menu.menu


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            homeViewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
            sharedPreference = SharedPreference(requireContext())
            homeViewModel.isGrid.value = sharedPreference.getPreferences()
            homeViewModel.isGrid.observe(viewLifecycleOwner) {
                setLayout()
            }

            rvFood.setHasFixedSize(true)
            gridLayout()
            setLayout()

        }


    }

    private fun setLayout() {
        val btnSetLayout = binding.ivGrid
        val setLayoutManager = homeViewModel.isGrid.value ?: sharedPreference.getPreferences()

        viewLayout(setLayoutManager)
        btnSetLayout.setOnClickListener {
            val updateLayout = !setLayoutManager
            homeViewModel.isGrid.value = updateLayout
            sharedPreference.setPreferences(updateLayout)
        }
    }

    private fun viewLayout(isGrid: Boolean) {
        if (isGrid) {
            gridLayout()
            binding.ivGrid.setImageResource(R.drawable.ic_list)
        } else {
            linearLayout()
            binding.ivGrid.setImageResource(R.drawable.ic_grid)
        }
    }

    private fun linearLayout() {
        binding.apply {
            rvFood.layoutManager = LinearLayoutManager(requireActivity())
            val menuAdapter =
                MenuAdapter(foodlist, homeViewModel.isGrid.value ?: false, listener = { pickItem ->
                    val bundle = bundleOf("foodDetail" to pickItem)
                    findNavController().navigate(
                        R.id.action_homeFragment_to_foodDetailFragment,
                        bundle
                    )
                })
            rvFood.adapter = menuAdapter
        }
    }

    private fun gridLayout() {
        binding.rvFood.layoutManager = GridLayoutManager(requireActivity(), 2)
        val menuAdapter =
            MenuAdapter(foodlist, homeViewModel.isGrid.value ?: true, listener = { pickItem ->
                val bundle = bundleOf("foodDetail" to pickItem)
                findNavController().navigate(R.id.action_homeFragment_to_foodDetailFragment, bundle)
            })
        binding.rvFood.adapter = menuAdapter
    }
}
