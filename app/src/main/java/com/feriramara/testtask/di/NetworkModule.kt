package com.feriramara.testtask.di

import com.feriramara.testtask.data.SearchImage
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "Authorization: Client-ID LaBgKSFFMQWm0x5MXuM18Our4E-UqDjNnn6ckgikjyc"
const val BASE_URL = "https://api.unsplash.com/"

val networkModule = module{

    single {
        okHttp()
    }
    single {
        retrofit(BASE_URL)
    }
    single {
        get<Retrofit>().create(ServiceUtil::class.java)
    }

}

private fun okHttp() = OkHttpClient.Builder()
    .build()


private fun retrofit(baseUrl: String) = Retrofit.Builder()
    .callFactory(OkHttpClient.Builder().build())
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ServiceUtil {

    @Headers(API_KEY)
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String
    ): SearchImage

}