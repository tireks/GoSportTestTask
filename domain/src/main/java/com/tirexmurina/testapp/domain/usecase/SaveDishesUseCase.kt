package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.domain.repository.DishRepository

interface ISaveDishesUseCase {
    suspend operator fun invoke(list : List<Dish>)
}

class SaveDishesUseCase (
    private val repository: DishRepository
) : ISaveDishesUseCase{
    override suspend fun invoke(list: List<Dish>) {
        return try {
            repository.insertDishesLocal(list)
        } catch (localException : Exception) {
            throw localException
        }
    }
}