package com.feriramara.testtask.di

import android.content.Context
import com.feriramara.testtask.database.ImagesDao
import com.feriramara.testtask.repository.ImagesRepository
import com.feriramara.testtask.repository.ImagesRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideImagesRepository(api: ServiceUtil, context: Context, dao : ImagesDao): ImagesRepository {
        return ImagesRepositoryImpl(api, context, dao)
    }
    single { provideImagesRepository(get(), androidContext(), get()) }

}