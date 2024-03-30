package com.tirexmurina.testapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tirexmurina.testapp.databinding.ItemBannerListBinding
import com.tirexmurina.testapp.databinding.ItemTestBinding

class BannerListAdapter () : RecyclerView.Adapter<BannerItemViewHolder>(){

    var contents: List<Int> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBannerListBinding.inflate(inflater, parent, false)
        return BannerItemViewHolder(binding)
    }

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: BannerItemViewHolder, position: Int) {
        holder.bind(contents[position])
    }

}

class BannerItemViewHolder(
    private val binding: ItemBannerListBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        content: Int
    ){
        binding.textview.text = content.toString()
    }
}