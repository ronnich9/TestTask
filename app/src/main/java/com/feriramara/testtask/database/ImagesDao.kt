package com.feriramara.testtask.database

import com.feriramara.testtask.data.UnsplashImage

interface ImagesDao {
    fun add(images: UnsplashImage): Boolean
    fun findAll(): List<UnsplashImage>
}