package com.tirexmurina.testapp.data.remote.converters

import com.tirexmurina.testapp.data.local.models.DishModelLocal
import com.tirexmurina.testapp.data.remote.models.CategoryModelRemote
import com.tirexmurina.testapp.data.remote.models.DishModelRemote
import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.entity.Dish

class DishConverterFromRemote {
    fun convert(fromDish : DishModelRemote, categoryList: List<Category>) : Dish? {
        val categoryId = categoryList.find { it.name == fromDish.strCategory }?.id ?: return null
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
}