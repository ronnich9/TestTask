package com.feriramara.testtask

import android.app.Application
import com.feriramara.testtask.di.databaseModule
import com.feriramara.testtask.di.networkModule
import com.feriramara.testtask.di.repositoryModule
import com.feriramara.testtask.di.viewModelModule
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(networkModule)
            modules(viewModelModule)
            modules(databaseModule)
            modules(repositoryModule)

        }

        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

    }
}