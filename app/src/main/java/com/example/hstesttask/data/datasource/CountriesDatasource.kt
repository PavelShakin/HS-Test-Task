package com.example.hstesttask.data.datasource

import com.example.hstesttask.GetCountriesQuery
import kotlinx.coroutines.flow.Flow

interface CountriesDatasource {

    interface Local {

    }

    interface Remote {
        fun getCountriesList(): Flow<List<GetCountriesQuery.Country>>
    }
}