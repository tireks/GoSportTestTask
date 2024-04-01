package com.tirexmurina.testapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tirexmurina.testapp.databinding.ItemBannerListBinding

class BannerListAdapter : RecyclerView.Adapter<BannerItemViewHolder>() {

    // Список содержимого баннеров.
    var contents: List<Int> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged() // Уведомляем адаптер об изменениях в данных.
            // В рамках тестового примера вызывается notifyDataSetChanged() для простоты,
            // но на практике лучше использовать DiffUtil для оптимизации обновлений.
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerItemViewHolder {
        // Создание ViewHolder.
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBannerListBinding.inflate(inflater, parent, false)
        return BannerItemViewHolder(binding)
    }

    override fun getItemCount(): Int = contents.size // Получение количества элементов.

    override fun onBindViewHolder(holder: BannerItemViewHolder, position: Int) {
        // Привязка данных к ViewHolder.
        holder.bind(contents[position])
    }
}

class BannerItemViewHolder(private val binding: ItemBannerListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    // Привязка данных к макету элемента списка.
    fun bind(content: Int) {
        binding.itemImage.setImageResource(content) // Установка изображения баннера.
    }
}
