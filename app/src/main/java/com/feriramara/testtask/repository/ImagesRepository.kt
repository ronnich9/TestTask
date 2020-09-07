package com.feriramara.testtask.repository

import com.feriramara.testtask.data.UnsplashImage

interface ImagesRepository {
    suspend fun addImage(query: String)
    suspend fun getAllImages() : List<UnsplashImage>
}