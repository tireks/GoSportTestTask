package com.tirexmurina.testapp.data

import com.tirexmurina.testapp.data.local.CategoryDao
import com.tirexmurina.testapp.data.local.DishDao
import com.tirexmurina.testapp.data.local.converters.CategoryConverterFromLocal
import com.tirexmurina.testapp.data.local.converters.CategoryConverterToLocal
import com.tirexmurina.testapp.data.remote.CategoryAPI
import com.tirexmurina.testapp.data.remote.converters.CategoryConverterFromRemote
import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val service : CategoryAPI,
    private val converterFromRemote : CategoryConverterFromRemote,
    private val converterFromLocal : CategoryConverterFromLocal,
    private val converterToLocal: CategoryConverterToLocal,
    private val dao: CategoryDao
) : CategoryRepository{
    override suspend fun getCategoriesRemote(): List<Category> =
        service.getAllCategories().categories.map { converterFromRemote.convert(it) }

    override suspend fun getCategoriesLocal(): List<Category> =
        dao.getAllCategories().map { converterFromLocal.convert(it) }

    override suspend fun insertCategoriesLocal(categories: List<Category>) {
        val modelsList = categories.map { converterToLocal.convert(it) }
        dao.insertCategory(modelsList)
    }
}