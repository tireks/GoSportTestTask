package com.tirexmurina.testapp.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App {
    class App : Application()
}