package com.tirexmurina.testapp.di

import android.content.Context
import com.tirexmurina.testapp.data.CategoryRepositoryImpl
import com.tirexmurina.testapp.data.DishRepositoryImpl
import com.tirexmurina.testapp.data.local.AppDatabase
import com.tirexmurina.testapp.data.local.CategoryDao
import com.tirexmurina.testapp.data.local.DishDao
import com.tirexmurina.testapp.data.local.converters.CategoryConverterFromLocal
import com.tirexmurina.testapp.data.local.converters.CategoryConverterToLocal
import com.tirexmurina.testapp.data.local.converters.DishConverterFromLocal
import com.tirexmurina.testapp.data.local.converters.DishConverterToLocal
import com.tirexmurina.testapp.data.remote.CategoryAPI
import com.tirexmurina.testapp.data.remote.DishAPI
import com.tirexmurina.testapp.data.remote.converters.CategoryConverterFromRemote
import com.tirexmurina.testapp.data.remote.converters.DishConverterFromRemote
import com.tirexmurina.testapp.domain.repository.CategoryRepository
import com.tirexmurina.testapp.domain.repository.DishRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    // Предоставляем экземпляр Retrofit для работы с сетью.
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Предоставляет сервис для получения Dish через Retrofit.
    @Provides
    @Singleton
    fun providesDishesService(retrofit: Retrofit) : DishAPI {
        return retrofit.create(DishAPI::class.java)
    }

    // Предоставляет сервис для получения Category через Retrofit.
    @Provides
    @Singleton
    fun providesCategoriesService(retrofit: Retrofit) : CategoryAPI {
        return retrofit.create(CategoryAPI::class.java)
    }

    // Предоставляет экземпляр базы данных Room.
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext app: Context): AppDatabase {
        return AppDatabase.getDatabase(app)
    }

    // Предоставляет DAO для работы с Category из базы данных Room.
    @Provides
    @Singleton
    fun provideCategoryDao(database: AppDatabase): CategoryDao {
        return database.categoryDao()
    }

    // Предоставляет DAO для работы с Dish из базы данных Room.
    @Provides
    @Singleton
    fun provideDishDao(database: AppDatabase): DishDao {
        return database.dishDao()
    }

    // Предоставляет конвертеры для преобразования данных Dish из/в форматы сетевого и локального источников.
    // Аналогично для Category.
    @Provides
    @Singleton
    fun provideDishConverterFromRemote() : DishConverterFromRemote = DishConverterFromRemote()

    @Provides
    @Singleton
    fun provideDishConverterToLocal() : DishConverterToLocal = DishConverterToLocal()

    @Provides
    @Singleton
    fun provideDishConverterFromLocal() : DishConverterFromLocal = DishConverterFromLocal()

    @Provides
    @Singleton
    fun provideCategoryConverterFromRemote() : CategoryConverterFromRemote = CategoryConverterFromRemote()

    @Provides
    @Singleton
    fun provideCategoryConverterToLocal() : CategoryConverterToLocal = CategoryConverterToLocal()

    @Provides
    @Singleton
    fun provideCategoryConverterFromLocal() : CategoryConverterFromLocal = CategoryConverterFromLocal()


    // Предоставляет репозиторий для работы с Dish.
    @Provides
    @Singleton
    fun provideDishRepository(
        service: DishAPI,
        dao: DishDao,
        converterFromRemote: DishConverterFromRemote,
        converterToLocal: DishConverterToLocal,
        converterFromLocal: DishConverterFromLocal
    ) : DishRepository{
        return DishRepositoryImpl(
            service = service,
            dao = dao,
            converterFromRemote = converterFromRemote,
            converterToLocal = converterToLocal,
            converterFromLocal = converterFromLocal
        )
    }

    // Предоставляет репозиторий для работы с Category.
    @Provides
    @Singleton
    fun provideCategoryRepository(
        service: CategoryAPI,
        dao: CategoryDao,
        converterFromRemote: CategoryConverterFromRemote,
        converterToLocal: CategoryConverterToLocal,
        converterFromLocal: CategoryConverterFromLocal
    ) : CategoryRepository{
        return CategoryRepositoryImpl(
            service = service,
            dao = dao,
            converterFromRemote = converterFromRemote,
            converterToLocal = converterToLocal,
            converterFromLocal = converterFromLocal
        )
    }



}