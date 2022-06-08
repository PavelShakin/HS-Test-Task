package com.example.hstesttask.app.countries_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.hstesttask.GetCountriesQuery
import com.example.hstesttask.app.CountriesViewModel
import com.example.hstesttask.databinding.FragmentCountriesListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CountriesListFragment : Fragment(), CountryItemCallback {

    private lateinit var binding: FragmentCountriesListBinding

    private val countriesListAdapter = CountriesListAdapter(this as CountryItemCallback)
    private val countriesViewModel: CountriesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountriesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpCountriesListRecycler()

        viewLifecycleOwner.lifecycleScope.launch {
            countriesViewModel.getCountriesList().collect { list ->
                countriesListAdapter.submitList(list)

                countriesViewModel.selectCountry(list[0])
            }
        }
    }

    private fun setUpCountriesListRecycler() {
        binding.countriesRecycler.apply {
            adapter = countriesListAdapter
        }
    }

    //called when user click on country in list
    override fun countrySelected(country: GetCountriesQuery.Country) {
        countriesViewModel.selectCountry(country)
    }
}