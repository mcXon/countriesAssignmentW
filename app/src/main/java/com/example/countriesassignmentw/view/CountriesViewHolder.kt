package com.example.countriesassignmentw.view

import androidx.recyclerview.widget.RecyclerView
import com.example.countriesassignmentw.databinding.ItemLayoutBinding
import com.example.countriesassignmentw.model.CountryInformation

class CountriesViewHolder(private val binding : ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(countryInformation : CountryInformation){
        binding.tvNameRegion.text = String.format(countryInformation.name + ", " +countryInformation.region)
        binding.tvCapital.text = countryInformation.capital
        binding.tvCode.text = countryInformation.code
    }

}