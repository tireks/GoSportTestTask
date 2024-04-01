package com.tirexmurina.testapp.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryModelLocal(
    @PrimaryKey val id: String,
    val name: String
)
