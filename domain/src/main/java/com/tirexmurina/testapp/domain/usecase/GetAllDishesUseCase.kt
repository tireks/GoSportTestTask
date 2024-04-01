package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.domain.repository.DishRepository

interface IGetAllDishesUseCase {
    // Этот интерфейс определяет контракт для юзкейса, когда требуется получить все блюда.
    // Он предназначен для асинхронного использования, поэтому используется 'suspend'.
    // Оператор 'invoke' позволяет экземплярам этого интерфейса вызываться как функциям.
    // Функция возвращает список блюд.
    suspend operator fun invoke(): List<Dish>
}

class GetAllDishesUseCase(
    private val repository: DishRepository
) : IGetAllDishesUseCase {
    // Этот класс реализует интерфейс IGetAllDishesUseCase.
    // Он получает все блюда, используя предоставленное хранилище.

    override suspend fun invoke(): List<Dish> {
        // Реализация функции 'invoke', которая получает все блюда.

        val response = try {
            // Попытка получить блюда из удаленного источника данных.
            repository.getDishesRemote()
        } catch (remoteException: Exception) {
            // Если происходит исключение во время удаленного получения данных,
            // попробует получить блюда из локального источника данных.
            try {
                repository.getDishesLocal()
            } catch (localException: Exception) {
                // Если во время получения блюд из локального источника происходит исключение, повторно выбросит исключение.
                throw localException
            }
        }

        // Возвращение ответа, который может быть получен как из удаленного, так и из локального источника.
        return response
    }
}
