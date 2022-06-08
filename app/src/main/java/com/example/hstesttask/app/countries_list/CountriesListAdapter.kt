package com.example.hstesttask.app.countries_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hstesttask.GetCountriesQuery
import com.example.hstesttask.databinding.CountryListItemBinding

fun interface CountryItemCallback {
    fun countrySelected(country: GetCountriesQuery.Country)
}

class CountriesListAdapter(private val callback: CountryItemCallback) :
    ListAdapter<GetCountriesQuery.Country, CountriesListAdapter.CountriesListViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesListViewHolder {
        val binding = CountryListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CountriesListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountriesListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = currentList.size


    inner class CountriesListViewHolder(private val binding: CountryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(country: GetCountriesQuery.Country) {
            with(binding) {
                imgCountryEmoji.text = country.emoji
                txtCountryName.text = country.capital

                root.setOnClickListener {
                    callback.countrySelected(country)
                }
            }
        }
    }

    object Diff : DiffUtil.ItemCallback<GetCountriesQuery.Country>() {
        override fun areItemsTheSame(
            oldItem: GetCountriesQuery.Country,
            newItem: GetCountriesQuery.Country
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: GetCountriesQuery.Country,
            newItem: GetCountriesQuery.Country
        ): Boolean {
            return oldItem.continent == newItem.continent &&
                    oldItem.capital == newItem.capital &&
                    oldItem.phone == newItem.phone
        }
    }
}