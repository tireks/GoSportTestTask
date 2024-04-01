package com.tirexmurina.testapp.data.local.converters

import com.tirexmurina.testapp.data.local.models.DishModelLocal
import com.tirexmurina.testapp.domain.entity.Dish

class DishConverterFromLocal {
    fun convert(from : DishModelLocal) : Dish =
        with(from){
            Dish(
                id = dishId,
                title = title,
                description = description,
                image = image,
                category = category
            )
        }
}