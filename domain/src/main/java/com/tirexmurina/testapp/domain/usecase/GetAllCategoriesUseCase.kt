package com.tirexmurina.testapp.domain.usecase

import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.repository.CategoryRepository

interface IGetAllCategoriesUseCase {
    suspend operator fun invoke() : List<Category>
}


class GetAllCategoriesUseCase(
    private val repository: CategoryRepository
) : IGetAllCategoriesUseCase{
    override suspend fun invoke(): List<Category> {
        return try {
            repository.getCategoriesRemote()
        } catch (remoteException : Exception) {
            try {
                repository.getCategoriesLocal()
            } catch (localException : Exception) {
                throw localException
            }
        }
    }
}