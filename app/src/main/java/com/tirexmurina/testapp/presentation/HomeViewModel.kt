package com.tirexmurina.testapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.domain.usecase.IGetAllCategoriesUseCase
import com.tirexmurina.testapp.domain.usecase.IGetAllDishesUseCase
import com.tirexmurina.testapp.domain.usecase.IGetDishesByCategoryUseCase
import com.tirexmurina.testapp.domain.usecase.ISaveCategoriesUseCase
import com.tirexmurina.testapp.domain.usecase.ISaveDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
// Этот класс представляет ViewModel для фрагмента HomeFragment. Он управляет бизнес-логикой
// и обеспечивает взаимодействие между пользовательским интерфейсом и репозиториями данных.
class HomeViewModel @Inject constructor(
    private val getAllDishesUseCase: IGetAllDishesUseCase, // Используется для получения списка блюд
    private val getAllCategoriesUseCase: IGetAllCategoriesUseCase, // Используется для получения списка категорий
    private val getDishesByCategoryUseCase: IGetDishesByCategoryUseCase, // Используется для получения списка блюд по категории
    private val saveDishesUseCase: ISaveDishesUseCase, // Используется для сохранения списка блюд
    private val saveCategoriesUseCase: ISaveCategoriesUseCase // Используется для сохранения списка категорий
) : ViewModel() {

    // Состояние экрана
    private val _state = MutableLiveData<HomeViewState>(HomeViewState.Initial)
    val state: LiveData<HomeViewState> = _state
    // Активная категория
    private var activeCategory: Category

    // Инициализация активной категории при создании экземпляра ViewModel
    init {
        activeCategory = Category("", "")
    }

    // Получение данных о блюдах и категориях
    fun getData(){
        viewModelScope.launch {
            _state.value = HomeViewState.Loading // Установка состояния загрузки
            try {
                val dishes = getDishes() // Получение списка блюд
                val categories = getCategories() // Получение списка категорий
                try {
                    saveCategories(categories) // Сохранение списка категорий
                    saveDishes(dishes) // Сохранение списка блюд
                } catch (saveException : Exception){
                    Log.d("AAA", saveException.message.toString()) // Обработка ошибки сохранения
                }
                if (activeCategory.id == "Error"){ // Если активная категория содержит ошибку
                    activeCategory = categories[0] // Установка первой категории в качестве активной
                }
                // Установка состояния содержимого с полученными данными
                _state.value = HomeViewState.Content(
                    dishes,
                    categories,
                    activeCategory
                )
            }catch (dataException : Exception){
                // Установка состояния ошибки в случае возникновения исключения при получении данных
                _state.value = HomeViewState.Error(dataException.message ?: "Unknown error")
            }
        }
    }

    // Получение блюд по выбранной категории
    fun getDishesByCategory(category : Category){
        viewModelScope.launch {
            _state.value = HomeViewState.Loading // Установка состояния загрузки
            activeCategory = category // Установка выбранной категории как активной
            try {
                val dishes = getDishesByAttribute(category.name) // Получение блюд по выбранной категории
                val categories = getCategories() // Получение списка категорий
                // Установка состояния содержимого с полученными данными
                _state.value = HomeViewState.Content(
                    dishes,
                    categories,
                    activeCategory
                )
            } catch (dataException : Exception){
                // Установка состояния ошибки в случае возникновения исключения при получении данных
                _state.value = HomeViewState.Error(dataException.message ?: "Unknown error")
            }
        }
    }

    // Получение списка блюд
    private suspend fun getDishes() : List<Dish>{
        return getAllDishesUseCase()
    }

    // Получение списка категорий
    private suspend fun getCategories() : List<Category>{
        return getAllCategoriesUseCase()
    }

    // Сохранение списка блюд
    private suspend fun saveDishes(list : List<Dish>){
        return saveDishesUseCase(list)
    }

    // Сохранение списка категорий
    private suspend fun saveCategories(list : List<Category>){
        return saveCategoriesUseCase(list)
    }

    // Получение списка блюд по атрибуту
    private suspend fun getDishesByAttribute(category : String) : List<Dish> {
        return getDishesByCategoryUseCase(category)
    }

    // Перезапуск данных
    fun restartData() {
        activeCategory = Category("", "") // Сброс активной категории
        getData() // Получение данных
    }
}
