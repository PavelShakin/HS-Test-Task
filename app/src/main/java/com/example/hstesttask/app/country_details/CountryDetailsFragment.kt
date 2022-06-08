package com.example.hstesttask.app.country_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.hstesttask.R
import com.example.hstesttask.app.CountriesViewModel
import com.example.hstesttask.databinding.FragmentCountryDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCountryDetailsBinding
    private val countriesViewModel: CountriesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countriesViewModel.selectedCountry.observe(viewLifecycleOwner) { country ->
            with(binding) {
                emojiFlag.text = country.emoji

                txtCountryName.text = country.capital

                continent.txtType.text = getString(R.string.txtContinent)
                continent.txtData.text = country.continent.name

                name.txtType.text = getString(R.string.txtCapital)
                name.txtData.text = country.capital

                code.txtType.text = getString(R.string.txtCode)
                code.txtData.text = "+" + country.phone

                phone.txtType.text = getString(R.string.txtPhone)
                phone.txtData.text = getString(R.string.txtPhoneSample)

                currency.txtType.text = getString(R.string.txtCurrency)
                currency.txtData.text = country.currency

                language.txtType.text = getString(R.string.txtLanguage)
                language.txtData.text = country.languages[0].name
            }
        }
    }
}