package com.tirexmurina.testapp.data.remote

import com.tirexmurina.testapp.data.remote.models.CategoryModelRemote

// Модель данных для ответа от API, содержащая список категорий.
// необходимость для правильной десериализации
data class CategoryResponseRemote (
    val categories: List<CategoryModelRemote>
)
