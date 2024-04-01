package com.tirexmurina.testapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {

    // Этот метод предоставляет экземпляр CoroutineDispatcher для использования в приложении.
    // CoroutineDispatcher используется для управления корутинами и их выполнения в определенных потоках.
    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        // Здесь мы возвращаем экземпляр Dispatchers.IO, который представляет собой диспетчер
        // для выполнения операций ввода-вывода (I/O) в фоновом потоке.
        // Это позволяет выполнять блокирующие операции I/O без блокировки основного потока пользовательского интерфейса.
        return Dispatchers.IO
    }

}