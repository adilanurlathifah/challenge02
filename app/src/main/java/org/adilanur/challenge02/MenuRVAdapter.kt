package org.adilanur.challenge02

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuRVAdapter(
    private val menuList: ArrayList<Menu>,
    private val listener: OnItemClickListener,
    private val context: Context,
    private val isGrid: Boolean
) : RecyclerView.Adapter<MenuRVAdapter.MenuViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(menu: Menu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = if (isGrid) {
            LayoutInflater.from(parent.context).inflate(R.layout.menu_rv_item, parent, false)
        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.menu_rv_item_list, parent, false)
        }
        return MenuViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.menuNameTV.text = menuList[position].menuName
        holder.menuImgIV.setImageResource(menuList[position].menuImg)

        holder.itemView.setOnClickListener {
            listener.onItemClick(menuList[position])
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menuNameTV: TextView = itemView.findViewById(R.id.idTVMenu)
        val menuImgIV: ImageView = itemView.findViewById(R.id.idIVMenu)
    }
}