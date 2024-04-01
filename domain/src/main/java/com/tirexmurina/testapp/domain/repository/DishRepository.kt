package com.tirexmurina.testapp.domain.repository

import com.tirexmurina.testapp.domain.entity.Dish

interface DishRepository {

    suspend fun getDishesRemote() : List<Dish>

    suspend fun getDishesLocal() : List<Dish>

    suspend fun getDishesByCategoryLocal(category: String) : List<Dish>

    suspend fun insertDishesLocal(dishes : List<Dish>)
}