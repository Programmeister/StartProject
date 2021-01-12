package com.epam.android.startProject.data.db

import androidx.room.Entity

@Entity(tableName = "cats")
data class Cat(
    val id: Int,
    val url: String
)