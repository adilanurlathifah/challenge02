package org.adilanur.challenge02.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.adilanur.challenge02.databinding.GridLayoutBinding
import org.adilanur.challenge02.model.Foods


class GridFoodAdapter(private val onItemClick: (Foods) -> Unit) :
    RecyclerView.Adapter<GridFoodItemListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridFoodItemListViewHolder {
        return GridFoodItemListViewHolder(
            binding = GridLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClick = onItemClick
        )
    }

    override fun onBindViewHolder(holder: GridFoodItemListViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Foods>(){
        override fun areItemsTheSame(oldItem: Foods, newItem: Foods): Boolean {
            return oldItem.name == newItem.name  && oldItem.desc == newItem.desc && oldItem.desc == newItem.desc && oldItem.desc == newItem.desc && oldItem.desc == newItem.desc
        }

        override fun areContentsTheSame(oldItem: Foods, newItem: Foods): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    })


}


class GridFoodItemListViewHolder(
    private val binding: GridLayoutBinding,
    private val onItemClick: (Foods) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(food: Foods) {
        with(binding) {
            tvFoodName1.text = food.name
            tvPrice1.text = "Rp " + food.price.toString()
            imageView2.load(food.img)
        }
        binding.root.setOnClickListener {
            onItemClick.invoke(food)
        }
    }
}