package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.domain.repository.DishRepository

interface IGetDishesByCategoryUseCase {
    // Этот интерфейс определяет контракт для юзкейса, когда требуется получить блюда по категории.
    // Он предназначен для асинхронного использования, поэтому используется 'suspend'.
    // Оператор 'invoke' позволяет экземплярам этого интерфейса вызываться как функциям.
    // Функция принимает строку категории и возвращает список блюд.
    suspend operator fun invoke(category: String): List<Dish>
}

class GetDishesByCategoryUseCase(
    private val repository: DishRepository
) : IGetDishesByCategoryUseCase {
    // Этот класс реализует интерфейс IGetDishesByCategoryUseCase.
    // Он получает блюда по указанной категории, используя предоставленное хранилище.

    override suspend fun invoke(category: String): List<Dish> {
        // Реализация функции 'invoke', которая получает блюда по категории.

        return try {
            // Попытка получить блюда из локального источника данных по указанной категории.
            repository.getDishesByCategoryLocal(category)
        } catch (localException: Exception) {
            // Если во время получения блюд по категории из локального источника происходит исключение, выбросит исключение.
            throw localException
        }
    }
}