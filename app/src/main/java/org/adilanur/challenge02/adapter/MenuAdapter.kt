package org.adilanur.challenge02.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.adilanur.challenge02.databinding.GridLayoutBinding
import org.adilanur.challenge02.databinding.ListLayoutBinding
import org.adilanur.challenge02.model.Foods


class MenuAdapter(private val data: List<Any>, val isGrid: Boolean, private var listener: (Foods) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (isGrid) {
            val binding =
                GridLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            GridMenuHolder(binding)

        } else {
            val binding =
                ListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LinearMenuHolder(binding)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isGrid) {
            val gridHolder = holder as GridMenuHolder
            gridHolder.onBind(data[position] as Foods)
            val listenerItem = data[position]
            holder.itemView.setOnClickListener{
                listener(listenerItem as Foods)
            }

        } else {
            val linearholder = holder as LinearMenuHolder
            linearholder.onBind(data[position] as Foods)
            val listenerItem = data[position]
            holder.itemView.setOnClickListener{
                listener(listenerItem as Foods)
            }
        }
    }

    override fun getItemCount(): Int = data.size
}

class GridMenuHolder(private val binding: GridLayoutBinding)
    : RecyclerView.ViewHolder(binding.root) {
    fun onBind(menu: Foods) {
        binding.apply {
            tvFoodName1.text= menu.name
            tvPrice1.text = menu.price.toString()
            imageView2.load(menu.img)

        }

    }

}

class LinearMenuHolder(private val binding: ListLayoutBinding)
    : RecyclerView.ViewHolder(binding.root) {
    fun onBind(menu: Foods) {
        binding.apply {
            tvListName1.text = menu.name
            tvListPrice1.text = menu.price.toString()
            ivListFood1.load(menu.img)
        }

    }
}