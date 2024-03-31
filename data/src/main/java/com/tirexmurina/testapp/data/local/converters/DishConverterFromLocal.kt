package com.tirexmurina.testapp.data.local.converters

import com.tirexmurina.testapp.data.local.models.CategoryModelLocal
import com.tirexmurina.testapp.data.local.models.DishModelLocal
import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.entity.Dish

class DishConverterFromLocal {
    fun convert(fromDish : DishModelLocal) : Dish =
        Dish(
            id = fromDish.dishId,
            title = fromDish.title,
            description = fromDish.description,
            image = fromDish.image,
            category =
        )
}