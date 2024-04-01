package com.tirexmurina.testapp.data

import com.tirexmurina.testapp.data.local.DishDao
import com.tirexmurina.testapp.data.local.converters.CategoryConverterFromLocal
import com.tirexmurina.testapp.data.local.converters.DishConverterFromLocal
import com.tirexmurina.testapp.data.local.converters.DishConverterToLocal
import com.tirexmurina.testapp.data.remote.DishAPI
import com.tirexmurina.testapp.data.remote.converters.DishConverterFromRemote
import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.domain.repository.DishRepository

class DishRepositoryImpl(
    private val service : DishAPI,
    private val converterFromLocal: DishConverterFromLocal,
    private val converterToLocal: DishConverterToLocal,
    private val converterFromRemote: DishConverterFromRemote,
    private val dao : DishDao
) : DishRepository {

    override suspend fun getDishesRemote(): List<Dish> =
        service.getAllDishes().meals.map { converterFromRemote.convert(it) }

    override suspend fun getDishesLocal(): List<Dish> =
        dao.getAllDishes().map { converterFromLocal.convert(it) }

    override suspend fun getDishesByCategoryLocal(category: String): List<Dish> =
        dao.getDishesByCategory(category).map { converterFromLocal.convert(it) }

    override suspend fun insertDishesLocal(dishes: List<Dish>) {
        val modelsList = dishes.map { converterToLocal.convert(it) }
        dao.insertDish(modelsList)
    }


}