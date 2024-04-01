package com.tirexmurina.testapp.di

import com.tirexmurina.testapp.domain.repository.CategoryRepository
import com.tirexmurina.testapp.domain.repository.DishRepository
import com.tirexmurina.testapp.domain.usecase.GetAllCategoriesUseCase
import com.tirexmurina.testapp.domain.usecase.GetAllDishesUseCase
import com.tirexmurina.testapp.domain.usecase.GetDishesByCategoryUseCase
import com.tirexmurina.testapp.domain.usecase.IGetAllCategoriesUseCase
import com.tirexmurina.testapp.domain.usecase.IGetAllDishesUseCase
import com.tirexmurina.testapp.domain.usecase.IGetDishesByCategoryUseCase
import com.tirexmurina.testapp.domain.usecase.ISaveCategoriesUseCase
import com.tirexmurina.testapp.domain.usecase.ISaveDishesUseCase
import com.tirexmurina.testapp.domain.usecase.SaveCategoriesUseCase
import com.tirexmurina.testapp.domain.usecase.SaveDishesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    // Предоставляет use case для получения всех Category.
    @Provides
    fun provideGetAllCategoriesUseCase(categoryRepository: CategoryRepository): IGetAllCategoriesUseCase {
        return GetAllCategoriesUseCase(repository = categoryRepository)
    }

    // Предоставляет use case для сохранения Category.
    @Provides
    fun provideSaveCategoriesUseCase(categoryRepository: CategoryRepository): ISaveCategoriesUseCase {
        return SaveCategoriesUseCase(repository = categoryRepository)
    }

    // Предоставляет use case для получения всех Dish.
    @Provides
    fun provideGetAllDishesUseCase(dishRepository: DishRepository): IGetAllDishesUseCase {
        return GetAllDishesUseCase(repository = dishRepository)
    }

    // Предоставляет use case для получения Dish по Category.
    @Provides
    fun provideGetDishesByCategoryUseCase(dishRepository: DishRepository): IGetDishesByCategoryUseCase {
        return GetDishesByCategoryUseCase(repository = dishRepository)
    }

    // Предоставляет use case для сохранения Dish.
    @Provides
    fun provideSaveDishesUseCase(dishRepository: DishRepository): ISaveDishesUseCase {
        return SaveDishesUseCase(repository = dishRepository)
    }
}