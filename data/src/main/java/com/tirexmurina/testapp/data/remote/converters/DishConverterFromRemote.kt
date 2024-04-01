package com.tirexmurina.testapp.data.remote.converters

import com.tirexmurina.testapp.data.remote.models.DishModelRemote
import com.tirexmurina.testapp.domain.entity.Dish

// Класс-конвертер для преобразования модели блюда от API в объект сущности блюда.
class DishConverterFromRemote {
    // Метод для преобразования объекта блюда от API в объект сущности блюда.
    fun convert(from: DishModelRemote): Dish =
        with(from) {
            Dish(
                id = idMeal,
                title = strMeal,
                image = strMealThumb,
                description = strInstructions,
                category = strCategory
            )
        }
}

