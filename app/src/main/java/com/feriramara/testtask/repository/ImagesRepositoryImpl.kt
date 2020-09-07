package com.feriramara.testtask.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.feriramara.testtask.data.UnsplashImage
import com.feriramara.testtask.database.ImagesDao
import com.feriramara.testtask.di.ServiceUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImagesRepositoryImpl(
    private val api: ServiceUtil,
    private val context: Context,
    private val dao: ImagesDao) : ImagesRepository{


    override suspend fun addImage(query: String) {
        try {
            val response = api.searchPhotos(query)
            withContext(Dispatchers.IO) {
                val image = response.results[0]
                image.query_search = query
                dao.add(image)
            }
        } catch (e: Exception) {
            Toast.makeText(context, "check network connection", Toast.LENGTH_SHORT).show()
        }
    }


    override suspend fun getAllImages(): List<UnsplashImage> {
        return withContext(Dispatchers.IO) {
            dao.findAll()
        }
    }
}