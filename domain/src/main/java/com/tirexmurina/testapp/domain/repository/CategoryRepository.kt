package com.tirexmurina.testapp.domain.repository

import com.tirexmurina.testapp.domain.entity.Category

interface CategoryRepository {

    suspend fun getCategoriesRemote() : List<Category>

    suspend fun getCategoriesLocal() : List<Category>

    suspend fun insertCategoriesLocal(categories : List<Category>)

}