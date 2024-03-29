package com.tirexmurina.testapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tirexmurina.testapp.databinding.ItemTestBinding

class MainListAdapter() : RecyclerView.Adapter<MainItemViewHolder>(){

    var contents: List<Int> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTestBinding.inflate(inflater, parent, false)
        return MainItemViewHolder(binding)
    }

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        holder.bind(contents[position])
    }
}

class MainItemViewHolder(
    private val binding: ItemTestBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        content: Int
    ){
        binding.itemContent.text = content.toString()
    }
}