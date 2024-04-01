package com.tirexmurina.testapp.data.remote.converters

import com.tirexmurina.testapp.data.local.models.DishModelLocal
import com.tirexmurina.testapp.data.remote.models.CategoryModelRemote
import com.tirexmurina.testapp.data.remote.models.DishModelRemote
import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.entity.Dish

class DishConverterFromRemote {
    fun convert(from : DishModelRemote) : Dish =
        with(from){
            Dish(
                id = idMeal,
                title = strMeal,
                image = strMealThumb,
                description = strInstructions,
                category = strCategory
            )
    }
}



        /*with(from){
            Dish(
                id = idMeal,
                title = strMeal,
                image = strMealThumb,
                description = strInstructions,
                category = Category(
                    id = strCategory.idCategory,
                    name = strCategory.strCategory
                )
            )
        }*/

    /*val categoryId = categoryList.find { it.name == fromDish.strCategory }?.id ?: return null
        with(fromDish){
            return Dish(
                id = idMeal,
                title = strMeal,
                image = strMealThumb,
                description = strInstructions,
                category = Category(
                    id = categoryId,
                    name = fromDish.strCategory
                )
            )
        }*/
