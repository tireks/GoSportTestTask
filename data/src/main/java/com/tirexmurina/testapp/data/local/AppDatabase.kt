package com.tirexmurina.testapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tirexmurina.testapp.data.local.models.CategoryModelLocal
import com.tirexmurina.testapp.data.local.models.DishModelLocal

// Абстрактный класс базы данных приложения.
@Database(entities = [CategoryModelLocal::class, DishModelLocal::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // Абстрактная функция для доступа к DAO для категорий.
    abstract fun categoryDao(): CategoryDao

    // Абстрактная функция для доступа к DAO для блюд.
    abstract fun dishDao(): DishDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Функция для получения экземпляра базы данных.
        fun getDatabase(context: Context): AppDatabase {
            // Если база данных еще не инициализирована, то инициализируем ее.
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}