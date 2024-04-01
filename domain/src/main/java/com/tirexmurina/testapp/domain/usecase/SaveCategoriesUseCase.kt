package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.repository.CategoryRepository

interface ISaveCategoriesUseCase {
    suspend operator fun invoke(list : List<Category>)
}

class SaveCategoriesUseCase(
    private val repository: CategoryRepository
) : ISaveCategoriesUseCase{
    override suspend fun invoke(list: List<Category>) {
        return try {
            repository.insertCategoriesLocal(list)
        } catch (localException : Exception){
            throw localException
        }
    }
}