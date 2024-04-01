package com.tirexmurina.testapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tirexmurina.testapp.data.local.models.DishModelLocal

@Dao
interface DishDao {

    // Вставка или замена списка блюд.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDish(list: List<DishModelLocal>)

    // Получение всех блюд.
    @Query("SELECT * FROM dishes")
    suspend fun getAllDishes(): List<DishModelLocal>

    // Получение блюд по указанной категории.
    @Query("SELECT * FROM dishes WHERE category = :category")
    suspend fun getDishesByCategory(category: String): List<DishModelLocal>
}