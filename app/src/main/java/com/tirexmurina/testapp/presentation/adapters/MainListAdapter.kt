package com.tirexmurina.testapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.tirexmurina.testapp.R
import com.tirexmurina.testapp.databinding.ItemMainListBinding
import com.tirexmurina.testapp.domain.entity.Dish

class MainListAdapter : RecyclerView.Adapter<MainItemViewHolder>() {

    // Список содержимого Dish.
    var contents: List<Dish> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged() // Уведомляем адаптер об изменениях в данных.
            // В рамках тестового примера вызывается notifyDataSetChanged() для простоты,
            // но на практике лучше использовать DiffUtil для оптимизации обновлений.
        }

    // Создание ViewHolder для элемента списка.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainListBinding.inflate(inflater, parent, false)
        return MainItemViewHolder(binding)
    }

    // Получение количества элементов в списке.
    override fun getItemCount(): Int = contents.size

    // Привязка данных к ViewHolder.
    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        holder.bind(contents[position])
    }
}

class MainItemViewHolder(private val binding: ItemMainListBinding) : RecyclerView.ViewHolder(binding.root) {
    // Привязка данных к макету элемента списка.
    fun bind(content: Dish) {
        binding.itemTitle.text = content.title // Установка заголовка Dish.
        binding.itemDescription.text = content.description // Установка описания Dish.

        // Загрузка изображения Dish с помощью Glide и применение скругленных углов.
        Glide.with(binding.itemImage.context)
            .load(content.image)
            .apply(RequestOptions().transform(RoundedCorners(16)))
            .placeholder(R.drawable.ic_placeholder) // Показываем placeholder, пока изображение загружается.
            .error(R.drawable.ic_placeholder) // Показываем placeholder в случае ошибки загрузки изображения.
            .into(binding.itemImage)
    }
}
