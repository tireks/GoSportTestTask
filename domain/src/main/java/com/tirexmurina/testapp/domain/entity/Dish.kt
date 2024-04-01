package com.tirexmurina.testapp.domain.entity

// сущность блюда (в соответствии с DDD, полностью независимая)
data class Dish(
    val id : String,
    val title: String,
    val description: String,
    val image: String,
    val category: String
)
