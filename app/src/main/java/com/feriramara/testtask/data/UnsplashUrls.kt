package com.feriramara.testtask.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

open class UnsplashUrls (
    @PrimaryKey
    var id: Int? = 0,
    var thumb: String? = null,
    var small: String? = null,
    var regular: String? = null,
    var full: String? = null,
    var raw: String? = null
) : RealmObject()