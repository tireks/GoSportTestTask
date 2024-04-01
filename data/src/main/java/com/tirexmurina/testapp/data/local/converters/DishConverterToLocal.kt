package com.tirexmurina.testapp.data.local.converters

import com.tirexmurina.testapp.data.local.models.DishModelLocal
import com.tirexmurina.testapp.domain.entity.Dish

class DishConverterToLocal {
    fun convert(from : Dish) : DishModelLocal =
        with(from){
            DishModelLocal(
                dishId = id,
                category = category,
                description = description,
                image = image,
                title = title
            )
        }
}