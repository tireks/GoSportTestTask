package com.tirexmurina.testapp.data.local.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dishes")
data class DishModelLocal(
    @PrimaryKey val dishId: String,
    val title: String,
    val description: String,
    val image: String,
    val categoryId : String
)
