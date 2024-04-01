package com.tirexmurina.testapp.data.local.converters

import com.tirexmurina.testapp.data.local.models.DishModelLocal
import com.tirexmurina.testapp.domain.entity.Dish

// Класс-конвертер для преобразования локальной модели блюда в объект сущности блюда.
class DishConverterFromLocal {
    // Метод для преобразования локальной модели блюда в объект сущности блюда.
    fun convert(from: DishModelLocal): Dish =
        with(from) {
            // Создание объекта сущности модели блюда с использованием данных из локальной модели блюда.
            Dish(
                id = dishId,
                title = title,
                description = description,
                image = image,
                category = category
            )
        }
}
