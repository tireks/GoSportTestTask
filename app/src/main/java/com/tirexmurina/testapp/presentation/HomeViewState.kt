package com.tirexmurina.testapp.presentation

import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.entity.Dish

// Состояние экрана фрагмента HomeFragment.
sealed class HomeViewState {
    // Начальное состояние.
    data object Initial : HomeViewState()

    // Состояние загрузки данных.
    data object Loading : HomeViewState()

    // Состояние с содержимым, содержащее список блюд, список категорий и активную категорию.
    data class Content (
        val dishes : List<Dish>, // Список блюд.
        val categories : List<Category>, // Список категорий.
        val activeCategory : Category // Активная категория.
    ) : HomeViewState()

    // Состояние с ошибкой, содержащее сообщение об ошибке.
    data class Error(val errorMsg: String) : HomeViewState()
}
