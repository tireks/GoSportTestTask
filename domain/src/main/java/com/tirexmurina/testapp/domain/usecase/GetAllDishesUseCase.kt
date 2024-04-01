package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.domain.repository.CategoryRepository
import com.tirexmurina.testapp.domain.repository.DishRepository

interface IGetAllDishesUseCase {
    suspend operator fun invoke() : List<Dish>
}


class GetAllDishesUseCase(
    private val repository: DishRepository
) : IGetAllDishesUseCase {
    override suspend fun invoke(): List<Dish> {
        return try {
            repository.getDishesRemote()
        }catch (remoteException: Exception) {
            try {
                repository.getDishesLocal()
            } catch(localException : Exception) {
                throw localException
            }
        }
    }
}