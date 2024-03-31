package com.tirexmurina.testapp.data.local.converters

import com.tirexmurina.testapp.data.local.models.CategoryModelLocal
import com.tirexmurina.testapp.domain.entity.Category

class CategoryConverterToLocal {
    fun convert(from : Category) : CategoryModelLocal =
        with(from){
            CategoryModelLocal(
                id = id,
                name = name
            )
        }
}