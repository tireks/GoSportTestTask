package com.tirexmurina.testapp.data.local.converters

import com.tirexmurina.testapp.data.local.models.CategoryModelLocal
import com.tirexmurina.testapp.domain.entity.Category

// Класс-конвертер для преобразования объекта сущности категории в локальную модель категории.
class CategoryConverterToLocal {
    // Метод для преобразования объекта сущности категории в локальную модель категории.
    fun convert(from: Category): CategoryModelLocal =
        with(from) {
            // Создание объекта локальной модели категории с использованием данных из объекта сущности категории.
            CategoryModelLocal(
                id = id,
                name = name
            )
        }
}
