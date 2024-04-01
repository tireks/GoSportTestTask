package com.tirexmurina.testapp.di

import android.content.Context
import androidx.room.Room
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

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesDishesService(retrofit: Retrofit) : DishAPI {
        return retrofit.create(DishAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesCategoriesService(retrofit: Retrofit) : CategoryAPI {
        return retrofit.create(CategoryAPI::class.java)
    }

    /*@Provides
    @Singleton
    fun provideAppDatabase (@ApplicationContext app : Context) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "app_database"
    ).build()*/

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext app: Context): AppDatabase {
        return AppDatabase.getDatabase(app)
    }

    @Provides
    @Singleton
    fun provideCategoryDao(database: AppDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    @Singleton
    fun provideDishDao(database: AppDatabase): DishDao {
        return database.dishDao()
    }

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