package com.epam.android.startProject.domain

import com.epam.android.startProject.data.CatsRepository
import com.epam.android.startProject.data.db.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCatUseCase @Inject constructor(
    private val repository: CatsRepository
) {
    suspend fun getCats(): Flow<List<Cat>> {
        return repository.getCats().map { list ->
            list.sortedBy { it.id }
        }
    }
}