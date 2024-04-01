package com.tirexmurina.testapp.data

import com.tirexmurina.testapp.data.local.DishDao
import com.tirexmurina.testapp.data.local.converters.DishConverterFromLocal
import com.tirexmurina.testapp.data.local.converters.DishConverterToLocal
import com.tirexmurina.testapp.data.remote.DishAPI
import com.tirexmurina.testapp.data.remote.converters.DishConverterFromRemote
import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.domain.repository.DishRepository

//Реализация репозитория для блюд.
//Получает блюда из удаленного и локального источников данных и обеспечивает доступ к ним.

class DishRepositoryImpl(
    private val service : DishAPI,
    private val converterFromLocal: DishConverterFromLocal,
    private val converterToLocal: DishConverterToLocal,
    private val converterFromRemote: DishConverterFromRemote,
    private val dao : DishDao
) : DishRepository {

    override suspend fun getDishesRemote(): List<Dish> =
        //так как конвертеры не работают со списками, с помощью .map пробегаемся по списку
        service.getAllDishes().meals.map { converterFromRemote.convert(it) }

    override suspend fun getDishesLocal(): List<Dish> =
        //так как конвертеры не работают со списками, с помощью .map пробегаемся по списку
        dao.getAllDishes().map { converterFromLocal.convert(it) }

    override suspend fun getDishesByCategoryLocal(category: String): List<Dish> =
        //так как конвертеры не работают со списками, с помощью .map пробегаемся по списку
        dao.getDishesByCategory(category).map { converterFromLocal.convert(it) }

    override suspend fun insertDishesLocal(dishes: List<Dish>) {
        //так как конвертеры не работают со списками, с помощью .map пробегаемся по списку
        val modelsList = dishes.map { converterToLocal.convert(it) }
        dao.insertDish(modelsList)
    }


}