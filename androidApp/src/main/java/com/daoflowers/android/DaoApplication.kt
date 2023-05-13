package com.daoflowers.android

import android.app.Application
import com.daoflowers.android.di.androidModule
import com.daoflowers.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DaoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DaoApplication)
            androidLogger()
            modules(appModules + androidModule)
        }
    }

}