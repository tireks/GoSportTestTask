package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.repository.CategoryRepository

interface IGetAllCategoriesUseCase {
    // Этот интерфейс определяет контракт для юзкейса, когда требуется получить все категории.
    // Он предназначен для асинхронного использования, поэтому используется 'suspend'.
    // Оператор 'invoke' позволяет экземплярам этого интерфейса вызываться как функциям.
    // Функция возвращает список категорий.
    suspend operator fun invoke(): List<Category>
}

class GetAllCategoriesUseCase(
    private val repository: CategoryRepository
) : IGetAllCategoriesUseCase {
    // Этот класс реализует интерфейс IGetAllCategoriesUseCase.
    // Он получает все категории, используя предоставленное хранилище.

    override suspend fun invoke(): List<Category> {
        // Реализация функции 'invoke', которая получает все категории.
        val response = try {
            // Попытка получить категории из удаленного источника данных.
            repository.getCategoriesRemote()
        } catch (remoteException: Exception) {
            // Если происходит исключение во время удаленного получения данных,
            // попробует получить категории из локального источника данных.
            try {
                repository.getCategoriesLocal()
            } catch (localException: Exception) {
                // Если во время получения данных из локального источника происходит исключение, повторно выбросит исключение.
                throw localException
            }
        }
        // Возвращение ответа, который может быть получен как из удаленного, так и из локального источника.
        return response
    }
}
