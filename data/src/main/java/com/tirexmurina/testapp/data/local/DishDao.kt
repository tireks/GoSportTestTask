package com.tirexmurina.testapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tirexmurina.testapp.data.local.models.DishModelLocal

@Dao
interface DishDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDish(dish: DishModelLocal)

    @Query("SELECT * FROM dishes")
    suspend fun getAllDishes(): List<DishModelLocal>
}