package com.tirexmurina.testapp.data.remote.converters

import com.tirexmurina.testapp.data.remote.models.CategoryModelRemote
import com.tirexmurina.testapp.domain.entity.Category

class CategoryConverterFromRemote {
    fun convert(from : CategoryModelRemote) : Category =
        with(from){
            Category(
                id = idCategory,
                name = strCategory
            )
        }
}