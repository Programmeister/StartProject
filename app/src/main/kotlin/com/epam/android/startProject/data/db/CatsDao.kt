package com.epam.android.startProject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CatsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCats(cats: List<Cat>)

    @Query("SELECT * FROM cats")
    suspend fun getCats(): Flow<List<Cat>>
}