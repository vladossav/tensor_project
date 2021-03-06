package com.example.tensor_project.model

import com.squareup.moshi.Json

data class RandomWord(
    @Json(name = "definition")
    val definition: String,
    @Json(name = "word")
    val word: String
)