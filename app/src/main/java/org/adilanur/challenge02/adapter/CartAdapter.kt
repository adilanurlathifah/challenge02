package org.adilanur.challenge02.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.adilanur.challenge02.data.dao.CartDao
import org.adilanur.challenge02.databinding.ItemCartBinding
import org.adilanur.challenge02.model.Cart
class CartAdapter(private val cartDao: CartDao) :
    RecyclerView.Adapter<CartAdapter.CartItemListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemListViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartItemListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartItemListViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(cartList: List<Cart>?) {
        differ.submitList(cartList)
    }

    private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Cart>() {
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.name == newItem.name &&
                    oldItem.price == newItem.price &&
                    oldItem.quantity == newItem.quantity &&
                    oldItem.img == newItem.img
        }

        override fun areContentsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    })

    inner class CartItemListViewHolder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(cart: Cart) {
            with(binding) {
                txtFoodName.text = cart.name
                txtPrice.text = "Rp " + cart.price.toString()
                qty.text = cart.quantity.toString()

                imgFood.load(cart.img)
                btnDelete.setOnClickListener {
                    val itemId = cart.itemId
                    itemId?.let {
                        cartDao.delteByItemId(it)
                    }
                }
            }
        }
    }
}
