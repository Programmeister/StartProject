package com.epam.android.startProject.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.epam.android.startProject.domain.GetCatUseCase

class HomeViewModel @ViewModelInject constructor(
    private val getCatUseCase: GetCatUseCase
) : ViewModel() {

}