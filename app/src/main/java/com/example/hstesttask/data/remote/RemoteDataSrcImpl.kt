package com.example.hstesttask.data.remote

import com.example.hstesttask.GetCountriesQuery
import com.example.hstesttask.data.datasource.CountriesDatasource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSrcImpl @Inject constructor(private val client: ApiClient) : CountriesDatasource.Remote {

    override fun getCountriesList() = flow {
        if (client.apolloClient.query(GetCountriesQuery()).execute().data?.continent?.countries != null) {
            emit(client.apolloClient.query(GetCountriesQuery()).execute().data?.continent?.countries!!)
        } else {
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)
}