package com.tirexmurina.testapp.data.remote

import com.tirexmurina.testapp.data.remote.models.DishModelRemote

// Класс данных для ответа от API с информацией о блюдах.
// необходимость для правильной десериализации
data class DishResponseRemote(
    val meals: List<DishModelRemote>
)
