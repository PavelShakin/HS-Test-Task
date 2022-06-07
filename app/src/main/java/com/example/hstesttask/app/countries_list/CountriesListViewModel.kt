package com.example.hstesttask.app.countries_list

import androidx.lifecycle.ViewModel
import com.example.hstesttask.GetCountriesQuery
import com.example.hstesttask.domain.usecase.GetCountriesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CountriesListViewModel @Inject constructor(
    private val getCountriesListUseCase: GetCountriesListUseCase
) : ViewModel() {

    fun getCountriesList(): Flow<List<GetCountriesQuery.Country>> {
        return getCountriesListUseCase.invoke()
    }
}