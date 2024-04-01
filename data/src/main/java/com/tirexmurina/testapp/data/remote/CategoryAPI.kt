package com.tirexmurina.testapp.data.remote

import retrofit2.http.GET

// Интерфейс для взаимодействия с API для получения списка категорий.
interface CategoryAPI {

    // Метод для получения всех категорий от API.
    @GET("categories.php")
    suspend fun getAllCategories() : CategoryResponseRemote

}