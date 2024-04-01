package com.tirexmurina.testapp.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// модель сущности категории для локальной базы данных.
@Entity(tableName = "categories")
data class CategoryModelLocal(
    @PrimaryKey val id: String, // Первичный ключ
    val name: String // Название категории
)
