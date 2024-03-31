package com.tirexmurina.testapp.data.local

import androidx.room.Embedded
import androidx.room.Relation
import com.tirexmurina.testapp.data.local.models.CategoryModelLocal
import com.tirexmurina.testapp.data.local.models.DishModelLocal

data class CategoryWithDishes(
    @Embedded val category: CategoryModelLocal,
    @Relation(
        parentColumn = "id",
        entityColumn = "categoryId"
    )
    val dishes: List<DishModelLocal>
)
