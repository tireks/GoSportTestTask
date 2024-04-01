package com.tirexmurina.testapp.data.local.converters

import com.tirexmurina.testapp.data.local.models.CategoryModelLocal
import com.tirexmurina.testapp.domain.entity.Category

// Класс-конвертер для преобразования локальной модели категории в объект сущности категории.
class CategoryConverterFromLocal {
    // Метод для преобразования локальной модели категории в объект сущности категории.
    fun convert(from: CategoryModelLocal): Category =
        with(from) {
            // Создание объекта сущности категории с использованием данных из локальной модели.
            Category(
                id = id,
                name = name
            )
        }
}
