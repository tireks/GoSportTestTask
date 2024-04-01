package com.tirexmurina.testapp.data.remote

import retrofit2.http.GET

// Интерфейс для взаимодействия с API для получения списка блюд.
interface DishAPI {
    @GET("search.php?s")
    suspend fun getAllDishes(): DishResponseRemote
}