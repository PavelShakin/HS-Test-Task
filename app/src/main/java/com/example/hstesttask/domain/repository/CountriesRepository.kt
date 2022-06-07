package com.example.hstesttask.domain.repository

import com.example.hstesttask.GetCountriesQuery
import kotlinx.coroutines.flow.Flow

interface CountriesRepository {

    fun getCountriesList(): Flow<List<GetCountriesQuery.Country>>
}