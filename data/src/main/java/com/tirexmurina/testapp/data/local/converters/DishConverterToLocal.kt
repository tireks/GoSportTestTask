package com.tirexmurina.testapp.data.local.converters

import com.tirexmurina.testapp.data.local.models.DishModelLocal
import com.tirexmurina.testapp.domain.entity.Dish

// Класс-конвертер для преобразования объекта сущности блюда в локальную модель блюда.
class DishConverterToLocal {
    // Метод для преобразования объекта сущности блюда в локальную модель блюда.
    fun convert(from: Dish): DishModelLocal =
        with(from) {
            // Создание объекта локальной модели блюда с использованием данных из объекта сущности блюда.
            DishModelLocal(
                dishId = id,
                category = category,
                description = description,
                image = image,
                title = title
            )
        }
}
