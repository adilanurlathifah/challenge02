package org.adilanur.challenge02.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.adilanur.challenge02.databinding.MenuItemBinding
import org.adilanur.challenge02.model.ListMenu

class MenuAdapter : ListAdapter<ListMenu, MenuAdapter.MenuViewHolder>(Differ()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding =
            MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }


    inner class MenuViewHolder(
        private val binding: MenuItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(menu: ListMenu) {
            binding.apply {
                txtFoodName.text = menu.nama
                txtFoodPrice.text = "Rp " + menu.harga.toString()
                imgFood.load(menu.image_url)
            }
        }
    }

    class Differ : DiffUtil.ItemCallback<ListMenu>() {
        override fun areItemsTheSame(oldItem: ListMenu, newItem: ListMenu): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ListMenu, newItem: ListMenu): Boolean {
            return oldItem == newItem
        }
    }

    companion object {

    }
}
