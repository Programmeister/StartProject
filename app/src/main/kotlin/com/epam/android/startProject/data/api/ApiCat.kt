package com.epam.android.startProject.data.api

import kotlinx.serialization.Serializable

@Serializable
data class ApiCat(
    val id: Int,
    val url: String
)
