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
    suspend fun insertCategory(list: List<CategoryModelLocal>)

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<CategoryModelLocal>
}