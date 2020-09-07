package com.feriramara.testtask.data

import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


open class UnsplashImage(
    @PrimaryKey
    var id: String? = null,
    var created_at: String? = null,
    var description: String? = null,
    var urls: UnsplashUrls? = null,
    var query_search: String? = null
) : RealmObject()