package com.example.hstesttask.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hstesttask.GetCountriesQuery
import com.example.hstesttask.domain.usecase.GetCountriesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesListUseCase: GetCountriesListUseCase
) : ViewModel() {

    private val mutableSelectedCountry = MutableLiveData<GetCountriesQuery.Country>()
    val selectedCountry: LiveData<GetCountriesQuery.Country> get() = mutableSelectedCountry

    fun selectCountry(country: GetCountriesQuery.Country) {
        mutableSelectedCountry.value = country
    }

    fun getCountriesList(): Flow<List<GetCountriesQuery.Country>> {
        return getCountriesListUseCase.invoke()
    }
}