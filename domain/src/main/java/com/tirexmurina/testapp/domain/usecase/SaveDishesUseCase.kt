package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.domain.repository.DishRepository

interface ISaveDishesUseCase {
    // Этот интерфейс определяет контракт для юзкейса, когда требуется сохранить блюда.
    // Он предназначен для асинхронного использования, поэтому используется 'suspend'.
    // Оператор 'invoke' позволяет экземплярам этого интерфейса вызываться как функциям.
    // Функция принимает список блюд для сохранения.
    suspend operator fun invoke(list: List<Dish>)
}

class SaveDishesUseCase(
    private val repository: DishRepository
) : ISaveDishesUseCase {
    // Этот класс реализует интерфейс ISaveDishesUseCase.
    // Он сохраняет список блюд, используя предоставленное хранилище.

    override suspend fun invoke(list: List<Dish>) {
        // Реализация функции 'invoke', которая сохраняет блюда.

        return try {
            // Попытка вставить блюда в локальное хранилище.
            repository.insertDishesLocal(list)
        } catch (localException: Exception) {
            // Если во время вставки блюд в локальное хранилище происходит исключение, выбросит исключение.
            throw localException
        }
    }
}