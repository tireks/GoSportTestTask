package com.tirexmurina.testapp.data.remote

import retrofit2.http.GET

interface DishAPI {
    @GET("search.php?s")
    suspend fun getAllDishes() : DishResponseRemote
}