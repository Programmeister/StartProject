package com.epam.android.startProject.data

import android.content.Context
import android.widget.Toast
import by.kirich1409.result.asSuccess
import by.kirich1409.result.isSuccess
import com.epam.android.startProject.R
import com.epam.android.startProject.data.api.CatsService
import com.epam.android.startProject.data.db.Cat
import com.epam.android.startProject.data.db.CatsDao
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val api: CatsService,
    private val dao: CatsDao,
    @ApplicationContext private val appContext: Context
) : CatsRepository {

    private val scope = CoroutineScope(Dispatchers.Default)

    init {
        scope.launch {
            loadCats()
        }
    }

    private suspend fun loadCats() {
        withContext(Dispatchers.IO) {
            val result = api.getCats()
            if (result.isSuccess()) {
                dao.addCats(result.asSuccess().value)
            } else {
                Toast.makeText(
                    appContext,
                    appContext.getString(R.string.loading_error),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override suspend fun getCats(): Flow<List<Cat>> {
        return withContext(Dispatchers.IO) {
            dao.getCats()
        }
    }
}