package org.adilanur.challenge02.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.adilanur.challenge02.adapter.CartAdapter
import org.adilanur.challenge02.data.database.Appdatabase
import org.adilanur.challenge02.databinding.FragmentKeranjangBinding


class KeranjangFragment : Fragment() {
    private lateinit var binding : FragmentKeranjangBinding
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentKeranjangBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cartRecyclerView = binding.cartRecyclerView
        val dataSource = Appdatabase.getInstance(requireContext()).dao

        binding.btnCheckout.setOnClickListener {
            showDialog()
        }

        cartAdapter = CartAdapter(dataSource)

        cartRecyclerView.adapter = cartAdapter
        cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        dataSource.getAllItem().observe(viewLifecycleOwner) { cartList ->
            if (cartList.isEmpty()) {
                binding.stateEmpty.visibility = View.VISIBLE
                binding.contextPesan.visibility = View.GONE
            } else {
                binding.stateEmpty.visibility = View.GONE
                binding.contextPesan.visibility = View.VISIBLE
                cartAdapter.submitList(cartList)
            }
        }

    }

    private fun showDialog() {
        Toast.makeText(requireContext(), "Pesanan Anda Berhasil!", Toast.LENGTH_SHORT).show()
    }
}