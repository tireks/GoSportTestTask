package com.tirexmurina.testapp.data

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
    private val converterToLocal: CategoryConverterToLocal
) : CategoryRepository{
    override suspend fun getCategoriesRemote(): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoriesLocal(): List<Category> {
        TODO("Not yet implemented")
    }
}