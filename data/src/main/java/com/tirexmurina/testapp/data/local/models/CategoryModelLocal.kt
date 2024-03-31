package com.tirexmurina.testapp.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryModelLocal(
    @PrimaryKey val id: String,
    val name: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CategoryModelLocal) return false
        return id == other.id && name == other.name
    }

    override fun hashCode(): Int {
        return id.hashCode() * 31 + name.hashCode()
    }
}
