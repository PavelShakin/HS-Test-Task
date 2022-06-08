package com.example.hstesttask.data

import com.example.hstesttask.GetCountriesQuery
import com.example.hstesttask.data.datasource.CountriesDatasource
import com.example.hstesttask.domain.repository.CountriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val remoteDataSrcImpl: CountriesDatasource.Remote
) : CountriesRepository {

    override fun getCountriesList(): Flow<List<GetCountriesQuery.Country>> {
        return remoteDataSrcImpl.getCountriesList()
    }
}