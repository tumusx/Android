package com.github.tumusx.maxappmvvm.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.maxappmvvm.databinding.ItemsHomeContainerBinding
import com.github.tumusx.maxappmvvm.menu.enumType.MenuTypes

class MenuAdapter(private val selectItemCallback: () -> Unit) :
    RecyclerView.Adapter<MenuAdapter.MenuAdapterViewHolder>() {
    private val menuListItems = MenuTypes.menuTypes()

    inner class MenuAdapterViewHolder(val binding: ItemsHomeContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun configureUI(menuType: MenuTypes) {
            binding.imgTypeCard.setImageResource(menuType.imgTypeMenu)
            binding.txtTypeCard.setText(menuType.titleMenuType)
        }
    }

    override fun getItemCount() = menuListItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MenuAdapterViewHolder(ItemsHomeContainerBinding.inflate(LayoutInflater.from(parent.context)))


    override fun onBindViewHolder(holder: MenuAdapterViewHolder, position: Int) {
        holder.configureUI(menuListItems[position])
        holder.binding.root.setOnClickListener {
            if (menuListItems[position] == MenuTypes.CLIENT) selectItemCallback.invoke()
        }
    }
}