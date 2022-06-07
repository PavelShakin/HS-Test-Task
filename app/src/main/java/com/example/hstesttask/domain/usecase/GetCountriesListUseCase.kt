package com.example.hstesttask.domain.usecase

import com.example.hstesttask.GetCountriesQuery
import kotlinx.coroutines.flow.Flow

interface GetCountriesListUseCase {
    fun invoke(): Flow<List<GetCountriesQuery.Country>>
}