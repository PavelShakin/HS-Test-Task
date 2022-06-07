package com.example.hstesttask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hstesttask.app.countries_list.CountriesListFragment
import com.example.hstesttask.app.country_details.CountryDetailsFragment
import com.example.hstesttask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint(AppCompatActivity::class)
class MainActivity : Hilt_MainActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(binding.leftFragmentContainer.id, CountriesListFragment())
            .add(binding.rightFragmentContainer.id, CountryDetailsFragment())
            .commit()
    }
}