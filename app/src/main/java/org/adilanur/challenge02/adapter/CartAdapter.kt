package org.adilanur.challenge02.adapter

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
    RecyclerView.Adapter<CartItemListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemListViewHolder {
        return CartItemListViewHolder(
            binding = ItemCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartItemListViewHolder, position: Int) {
        holder.bind(differ.currentList[position], cartDao)
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(cartList: List<Cart>?) {
        differ.submitList(cartList)
        if (cartList != null) {
            notifyItemRangeChanged(0,cartList.size)
        }
    }

    private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Cart>(){
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.name == newItem.name  && oldItem.price == newItem.price && oldItem.quantity == newItem.quantity && oldItem.img == newItem.img
        }

        override fun areContentsTheSame(oldItem: Cart, newItem: Cart): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    })


}
class CartItemListViewHolder(
    private val binding: ItemCartBinding,) : RecyclerView.ViewHolder(binding.root) {
    fun bind(food: Cart, cartDao: CartDao) {
        with(binding) {
            txtFoodName.text = food.name
            txtPrice.text ="Rp " +  food.price.toString()
            qty.text = food.quantity.toString()

            imgFood.load(food.img)
            btnDelete.setOnClickListener {
                val itemId = food.itemId
                if (itemId != null) {
                    cartDao.delteByItemId(itemId)
                }

            }
        }

    }
}
