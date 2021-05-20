package com.sobarna.sobarnamovies.model

import androidx.room.Embedded
import androidx.room.PrimaryKey
import androidx.room.Relation

class FavoMovie (

    @Embedded
    var result: Result,
    @Relation(parentColumn = "id",entityColumn = "id")
    var listResult: List<Result>)
