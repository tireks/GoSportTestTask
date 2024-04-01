package com.tirexmurina.testapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tirexmurina.testapp.databinding.ItemCategoryInactiveBinding

class CategoriesListAdapter () : RecyclerView.Adapter<CategoriesItemViewHolder>() {

    var contents: List<Int> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryInactiveBinding.inflate(inflater, parent, false)
        return CategoriesItemViewHolder(binding)
    }

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: CategoriesItemViewHolder, position: Int) {
        holder.bind(contents[position])
    }

}

class CategoriesItemViewHolder(
    private val binding: ItemCategoryInactiveBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        content: Int
    ){
        binding.textview.text = content.toString()
    }
}