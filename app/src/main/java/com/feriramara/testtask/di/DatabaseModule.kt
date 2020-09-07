package com.feriramara.testtask.di

import com.feriramara.testtask.database.ImagesDao
import com.feriramara.testtask.database.ImagesDaoImpl
import org.koin.dsl.module


val databaseModule = module {

    fun provideImagesDao(): ImagesDao {
        return ImagesDaoImpl()
    }

    factory { provideImagesDao() }

}