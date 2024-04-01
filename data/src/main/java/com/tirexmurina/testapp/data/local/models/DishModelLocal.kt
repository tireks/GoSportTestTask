package com.tirexmurina.testapp.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// модель сущности блюда для локальной базы данных.
@Entity(tableName = "dishes")
data class DishModelLocal(
    @PrimaryKey val dishId: String, // Первичный ключ
    val title: String, // Название блюда
    val description: String, // Описание блюда
    val image: String, // URL изображения блюда
    val category: String // Категория блюда (идентификатор категории)
)
