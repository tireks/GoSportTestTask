package com.tirexmurina.testapp.data.remote.models

// Модель данных для блюда от API.
data class DishModelRemote (
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strInstructions: String,
    val strCategory: String
)
