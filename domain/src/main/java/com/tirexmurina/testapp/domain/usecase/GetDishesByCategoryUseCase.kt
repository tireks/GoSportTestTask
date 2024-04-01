package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.domain.repository.DishRepository

interface IGetDishesByCategoryUseCase {
    suspend operator fun invoke(category : String) : List<Dish>
}

class GetDishesByCategoryUseCase (
    private val repository: DishRepository
) : IGetDishesByCategoryUseCase {
    override suspend fun invoke(category: String): List<Dish> {
        return try {
            repository.getDishesByCategoryLocal(category)
        } catch (localException : Exception) {
            throw localException
        }
    }
}