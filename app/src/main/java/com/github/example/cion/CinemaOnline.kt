package com.github.example.cion

import android.app.Application
import com.github.example.cion.di.appModule
import com.github.example.cion.di.navModule
import com.github.example.cion.di.videoPlayerModule
import com.github.example.cion.feature.movies_screen.di.moviesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CinemaOnline : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@CinemaOnline)
            modules(
                appModule, navModule, moviesModule,
                videoPlayerModule
            )
        }
    }
}