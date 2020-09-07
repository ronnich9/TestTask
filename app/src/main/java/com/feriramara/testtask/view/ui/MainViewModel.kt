package com.feriramara.testtask.view.ui

import android.util.Log
import androidx.lifecycle.*
import com.feriramara.testtask.data.SearchImage
import com.feriramara.testtask.data.UnsplashImage
import com.feriramara.testtask.di.ServiceUtil
import com.feriramara.testtask.repository.ImagesRepository
import com.feriramara.testtask.repository.ImagesRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: ImagesRepository): ViewModel() {

    init {
        viewModelScope.launch {
            getAllImages()
        }
    }
    var images = MutableLiveData<List<UnsplashImage>>()

    fun saveImage(query: String) {
        viewModelScope.launch {
            repository.addImage(query)
            getAllImages()

        }
    }

    suspend fun getAllImages() {
        val result = repository.getAllImages()
        images.value = result
    }
}