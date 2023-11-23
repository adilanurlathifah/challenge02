package org.adilanur.challenge02.views.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import org.adilanur.challenge02.adapter.CategoryAdapter
import org.adilanur.challenge02.adapter.MenuAdapter
import org.adilanur.challenge02.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCategory()
        getMenu()

    }

    private fun getMenu() {
        viewModel.getMenu()

        viewModel.getListMenu.observe(viewLifecycleOwner) { list ->
            menuAdapter = MenuAdapter()

            binding.rvMenu.adapter = menuAdapter
            binding.rvMenu.layoutManager = GridLayoutManager(requireContext(), 2)

            menuAdapter.submitList(list?.data)

        }
    }

    private fun getCategory() {
        viewModel.getCategory()

        viewModel.getListCategory.observe(viewLifecycleOwner) { list ->
            categoryAdapter = CategoryAdapter()

            binding.rvCategory.adapter = categoryAdapter
            binding.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            categoryAdapter.submitList(list?.data)

        }
    }

}