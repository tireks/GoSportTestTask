package com.tirexmurina.testapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryAPI {

    @GET("categories.php")
    suspend fun getAllCategories() : CategoryResponseRemote

}