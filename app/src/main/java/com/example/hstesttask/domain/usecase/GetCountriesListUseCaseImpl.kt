package com.example.hstesttask.domain.usecase

import com.example.hstesttask.GetCountriesQuery
import com.example.hstesttask.domain.repository.CountriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCountriesListUseCaseImpl @Inject constructor(private val repository: CountriesRepository): GetCountriesListUseCase {
    override fun invoke(): Flow<List<GetCountriesQuery.Country>> {
        return repository.getCountriesList()
    }
}