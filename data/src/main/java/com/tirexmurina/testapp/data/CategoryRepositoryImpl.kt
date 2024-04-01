package com.tirexmurina.testapp.data

import com.tirexmurina.testapp.data.local.CategoryDao
import com.tirexmurina.testapp.data.local.converters.CategoryConverterFromLocal
import com.tirexmurina.testapp.data.local.converters.CategoryConverterToLocal
import com.tirexmurina.testapp.data.remote.CategoryAPI
import com.tirexmurina.testapp.data.remote.converters.CategoryConverterFromRemote
import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.repository.CategoryRepository

//Реализация репозитория для категорий.
// Получает категории из удаленного и локального источников данных и обеспечивает доступ к ним.

class CategoryRepositoryImpl(
    private val service : CategoryAPI,
    private val converterFromRemote : CategoryConverterFromRemote,
    private val converterFromLocal : CategoryConverterFromLocal,
    private val converterToLocal: CategoryConverterToLocal,
    private val dao: CategoryDao
) : CategoryRepository{
    override suspend fun getCategoriesRemote(): List<Category> =
        //так как конвертеры не работают со списками, с помощью .map пробегаемся по списку
        service.getAllCategories().categories.map { converterFromRemote.convert(it) }

    override suspend fun getCategoriesLocal(): List<Category> =
        //так как конвертеры не работают со списками, с помощью .map пробегаемся по списку
        dao.getAllCategories().map { converterFromLocal.convert(it) }

    override suspend fun insertCategoriesLocal(categories: List<Category>) {
        //так как конвертеры не работают со списками, с помощью .map пробегаемся по списку
        val modelsList = categories.map { converterToLocal.convert(it) }
        dao.insertCategory(modelsList)
    }

}