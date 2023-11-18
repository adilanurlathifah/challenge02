package org.adilanur.challenge02.views.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.adilanur.challenge02.R
import org.adilanur.challenge02.data.database.Appdatabase
import org.adilanur.challenge02.databinding.FragmentDetailBinding
import org.adilanur.challenge02.model.Cart
import org.adilanur.challenge02.model.Foods

class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    var quantity = ""
    var totalprice : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        return binding.root

//        btnLocation = findViewById(R.id.btn_location)
//
//        btnLocation.setOnClickListener {
//            val uri = Uri.parse("geo:-6.301215225215278, 106.65348182184478")
//            val locationIntent = Intent(Intent.ACTION_VIEW, uri)
//
//            locationIntent.setPackage("com.google.android.apps.maps")
//
//            if (locationIntent.resolveActivity(packageManager) != null) {
//                startActivity(locationIntent)
//            } else {
//                Toast.makeText(this, "Google Map Tidak Terinstall!", Toast.LENGTH_SHORT).show()
//            }
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel.counterLiveData.observe(viewLifecycleOwner) { result ->
            quantity = result.toString()
            binding.tvAmount.text = quantity
        }

        detailViewModel.totalPriceLiveData.observe(viewLifecycleOwner) {
            totalprice =it
            binding.totalPrice.text = "Rp"+it.toString()
        }

        incrementCount()
        decrementCount()
        with(binding) {

            var nameFood=""
            var imgFood:Int =0

            val foodDetail = arguments?.getParcelable<Foods>("foodDetail")
            foodDetail?.let {
                imgFood=it.img
                imgDetailFood.setImageResource(imgFood)
                subtitleFood.text = it.desc
                foodPrice.text = "Rp"+it.price.toString()
                nameFood= it.name
                titleFoodName.text = nameFood
                detailViewModel.initSelectedItem(it)

            }


            val dataSource = Appdatabase.getInstance(requireContext()).dao
            addToCart.setOnClickListener {
                Toast.makeText(requireContext(), "Pesanan Anda telah dimasukkan ke keranjang", Toast.LENGTH_SHORT).show()
                dataSource.insert(Cart(price = totalprice, quantity = quantity.toInt(), name = nameFood, img = imgFood))
            }
            dataSource.getAllItem().observe(requireActivity()){
                Log.e("SimpleDataBase", it.toString())
            }
        }

    }

    private fun incrementCount() {
        binding.cvPlus.setOnClickListener {
            detailViewModel.incrementCount()
            detailViewModel.updateTotalPrice()

        }
    }

    private fun decrementCount() {
        binding.cvMin.setOnClickListener {
            detailViewModel.decrementCount()
            detailViewModel.updateTotalPrice()
        }
    }
}