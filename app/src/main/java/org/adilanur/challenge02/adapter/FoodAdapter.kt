package org.adilanur.challenge02.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.adilanur.challenge02.databinding.ListLayoutBinding
import org.adilanur.challenge02.model.Foods

class FoodAdapter(private val onItemClick: (Foods) -> Unit) :
    RecyclerView.Adapter<FoodItemListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemListViewHolder {
        return FoodItemListViewHolder(
            binding = ListLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClick = onItemClick
        )
    }

    override fun onBindViewHolder(holder: FoodItemListViewHolder, position: Int) {
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


class FoodItemListViewHolder(
    private val binding: ListLayoutBinding,
    private val onItemClick: (Foods) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(food: Foods) {
        with(binding) {
            tvListName1.text = food.name
            tvListPrice1.text ="Rp " +  food.price.toString()
            ivListFood1.load(food.img)
        }
        binding.root.setOnClickListener{
            onItemClick.invoke(food)
        }
    }
}