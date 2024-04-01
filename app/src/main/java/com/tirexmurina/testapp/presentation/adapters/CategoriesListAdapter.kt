package com.tirexmurina.testapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tirexmurina.testapp.databinding.ItemCategoryActiveBinding
import com.tirexmurina.testapp.databinding.ItemCategoryInactiveBinding
import com.tirexmurina.testapp.domain.entity.Category

class CategoriesListAdapter(
    private val categoryClickListener: (Category) -> Unit, // Слушатель кликов на обычные Category.
    private val clearCategoryClickListener: () -> Unit // Слушатель клика на активную Category для ее очистки.
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var contents: List<Category> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged() // Уведомляем адаптер об изменениях в данных.
            // В рамках тестового примера вызывается notifyDataSetChanged() для простоты,
            // но на практике лучше использовать DiffUtil для оптимизации обновлений.
        }

    var activeCategory: Category? = null // Активная категория.

    // Создание ViewHolder в зависимости от типа представления (активная категория или обычная).
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ACTIVE) {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemCategoryActiveBinding.inflate(inflater, parent, false)
            ItemCategoryActiveViewHolder(binding)
        } else {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemCategoryInactiveBinding.inflate(inflater, parent, false)
            ItemCategoryNormalViewHolder(binding)
        }
    }

    // Получение количества элементов списка.
    override fun getItemCount(): Int = contents.size

    // Привязка данных к ViewHolder.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_ACTIVE -> {
                (holder as ItemCategoryActiveViewHolder).bind(
                    contents[position], clearCategoryClickListener
                )
            }

            VIEW_TYPE_NORMAL -> {
                (holder as ItemCategoryNormalViewHolder).bind(
                    contents[position], categoryClickListener
                )
            }
        }
    }

    // Получение типа представления для элемента списка.
    override fun getItemViewType(position: Int): Int {
        return if (position == 0 && activeCategory != null) {
            VIEW_TYPE_ACTIVE
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    companion object {
        const val VIEW_TYPE_ACTIVE = 1 // Тип представления для активной категории.
        const val VIEW_TYPE_NORMAL = 0 // Тип представления для обычной категории.
    }

}

// ViewHolder для обычной категории.
class ItemCategoryNormalViewHolder(private val binding: ItemCategoryInactiveBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(content: Category, categoryClickListener: (Category) -> Unit) {
        binding.textview.text = content.name
        itemView.setOnClickListener { categoryClickListener(content) } // Установка слушателя кликов на элемент списка.
    }
}

// ViewHolder для активной категории.
class ItemCategoryActiveViewHolder(private val binding: ItemCategoryActiveBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(content: Category, clearCategoryClickListener: () -> Unit) {
        binding.textview.text = content.name
        itemView.setOnClickListener { clearCategoryClickListener() } // Установка слушателя клика на элемент списка для очистки активной категории.
    }
}

