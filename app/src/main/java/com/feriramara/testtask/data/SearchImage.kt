package com.feriramara.testtask.data


data class SearchImage (
    val total: Int,
    val total_pages: Int,
    val results: List<UnsplashImage>
)