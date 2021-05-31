package com.sobarna.wecandoit

import android.app.Application
import com.sobarna.wecandoit.core.di.databaseModule
import com.sobarna.wecandoit.core.di.networkModule
import com.sobarna.wecandoit.core.di.repositoryModule
import com.sobarna.wecandoit.di.useCaseModule
import com.sobarna.wecandoit.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}