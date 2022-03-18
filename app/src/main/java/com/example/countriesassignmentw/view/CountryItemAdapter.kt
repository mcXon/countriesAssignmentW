package com.example.countriesassignmentw.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesassignmentw.databinding.ItemLayoutBinding
import com.example.countriesassignmentw.model.CountryInformation

class CountryItemAdapter(private val dataset: List<CountryInformation>) :
    RecyclerView.Adapter<CountriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CountriesViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false))


    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) =
        holder.onBind(dataset[position])

    override fun getItemCount() = dataset.size


}