package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.repository.CategoryRepository

interface ISaveCategoriesUseCase {
    // Этот интерфейс определяет контракт для юзкейса, когда требуется сохранить категории.
    // Он предназначен для асинхронного использования, поэтому используется 'suspend'.
    // Оператор 'invoke' позволяет экземплярам этого интерфейса вызываться как функциям.
    // Функция принимает список категорий для сохранения.
    suspend operator fun invoke(list: List<Category>)
}

class SaveCategoriesUseCase(
    private val repository: CategoryRepository
) : ISaveCategoriesUseCase {
    // Этот класс реализует интерфейс ISaveCategoriesUseCase.
    // Он сохраняет список категорий, используя предоставленное хранилище.

    override suspend fun invoke(list: List<Category>) {
        // Реализация функции 'invoke', которая сохраняет категории.

        return try {
            // Попытка вставить категории в локальное хранилище.
            repository.insertCategoriesLocal(list)
        } catch (localException: Exception) {
            // Если во время вставки категорий в локальное хранилище происходит исключение, выбрасывает исключение.
            throw localException
        }
    }
}