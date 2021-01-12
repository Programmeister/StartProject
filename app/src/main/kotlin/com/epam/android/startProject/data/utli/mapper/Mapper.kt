package com.epam.android.startProject.data.utli.mapper

interface Mapper<I, O> {
    fun map(list: List<I>): List<O>
}