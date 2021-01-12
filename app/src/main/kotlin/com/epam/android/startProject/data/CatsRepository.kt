package com.epam.android.startProject.data

import com.epam.android.startProject.data.db.Cat
import kotlinx.coroutines.flow.Flow

interface CatsRepository {

    suspend fun getCats(): Flow<List<Cat>>

}