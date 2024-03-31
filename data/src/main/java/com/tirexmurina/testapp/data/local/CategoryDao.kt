package com.tirexmurina.testapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.tirexmurina.testapp.data.local.models.CategoryModelLocal

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: CategoryModelLocal)

    @Transaction
    @Query("SELECT * FROM categories WHERE id = :id")
    suspend fun getCategoryWithDishes(categoryId : String): List<CategoryWithDishes>

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<CategoryModelLocal>
}