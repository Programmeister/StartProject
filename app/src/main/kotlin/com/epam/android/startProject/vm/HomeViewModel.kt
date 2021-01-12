package com.epam.android.startProject.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epam.android.startProject.data.db.Cat
import com.epam.android.startProject.domain.GetCatUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val getCatUseCase: GetCatUseCase
) : ViewModel() {

    private val _data = MutableStateFlow<List<Cat>>(emptyList())
    val data: StateFlow<List<Cat>> = _data

    init {
        viewModelScope.launch {
            getCatUseCase.getCats().collect {
                _data.value = it
            }
        }
    }
}