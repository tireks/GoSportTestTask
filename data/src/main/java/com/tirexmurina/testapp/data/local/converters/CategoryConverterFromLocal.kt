package com.tirexmurina.testapp.data.local.converters

import com.tirexmurina.testapp.data.local.models.CategoryModelLocal
import com.tirexmurina.testapp.domain.entity.Category

class CategoryConverterFromLocal {
    fun convert(from : CategoryModelLocal) : Category =
        with(from){
            Category(
                id = id,
                name = name
            )
        }
}