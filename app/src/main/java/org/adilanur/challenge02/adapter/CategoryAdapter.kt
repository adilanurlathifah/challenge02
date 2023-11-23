package org.adilanur.challenge02.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.adilanur.challenge02.databinding.CategoryItemBinding
import org.adilanur.challenge02.model.Category



class CategoryAdapter : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(Differ()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }


    inner class CategoryViewHolder(
        private val binding: CategoryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(category: Category) {
            binding.apply {
                tvCategoryName.text = category.nama
                civCategory.load(category.image_url)
            }
        }
    }

    class Differ : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }
    }

    companion object {

    }
}
