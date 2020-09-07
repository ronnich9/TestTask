package com.feriramara.testtask.database

import android.util.Log
import com.feriramara.testtask.data.UnsplashImage
import io.realm.Realm
import org.koin.dsl.module


class ImagesDaoImpl : ImagesDao {

    override fun add(unsplash_image: UnsplashImage): Boolean {
        return try {
            val realm = Realm.getDefaultInstance()
            unsplash_image.let {
                it.urls?.id = (setUniqueId())
            }
            realm.executeTransaction{realm1 ->
                realm1.insertOrUpdate(unsplash_image)
            }
            realm.close()
            true
        } catch (e: Exception) {
            println(e)
            Log.d("Adding Exception", e.message ?: "lol")
            false
        }
    }

    override fun findAll(): List<UnsplashImage> {
        val realm = Realm.getDefaultInstance()
        val list =  realm.copyFromRealm(realm.where(UnsplashImage::class.java).findAll())
        realm.close()
        return list
    }


    var num = 0
    fun setUniqueId(): Int {
        num += 1
        return num
    }
}