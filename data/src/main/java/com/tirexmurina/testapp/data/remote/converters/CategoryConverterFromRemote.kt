package com.tirexmurina.testapp.data.remote.converters

import com.tirexmurina.testapp.data.remote.models.CategoryModelRemote
import com.tirexmurina.testapp.domain.entity.Category

// Класс-конвертер для преобразования модели категории от API в объект сущности категории.
class CategoryConverterFromRemote {
    // Метод для преобразования объекта категории от API в объект сущности категории.
    fun convert(from: CategoryModelRemote): Category =
        with(from) {
            Category(
                id = idCategory,
                name = strCategory
            )
        }
}
