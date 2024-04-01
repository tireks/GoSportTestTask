package com.tirexmurina.testapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.tirexmurina.testapp.DishTestEntity
import com.tirexmurina.testapp.R
import com.tirexmurina.testapp.databinding.ItemMainListBinding

class MainListAdapter() : RecyclerView.Adapter<MainItemViewHolder>(){

    var contents: List<DishTestEntity> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainListBinding.inflate(inflater, parent, false)
        return MainItemViewHolder(binding)
    }

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        holder.bind(contents[position])
    }
}

class MainItemViewHolder(
    private val binding: ItemMainListBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        content: DishTestEntity
    ){
        binding.itemTitle.text = content.title
        binding.itemDescription.text = content.description
        binding.priceLabelText.text = "от ${content.price} р"
        Glide.with(binding.itemImage.context)
            .load(content.image)
            .apply(RequestOptions().transform(RoundedCorners(16)))
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_placeholder)
            .into(binding.itemImage)
    }
}