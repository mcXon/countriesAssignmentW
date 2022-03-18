package com.example.countriesassignmentw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SnapHelper
import com.example.countriesassignmentw.common.CountryResponseState
import com.example.countriesassignmentw.databinding.ActivityMainBinding
import com.example.countriesassignmentw.model.CountryInformation
import com.example.countriesassignmentw.view.CountryItemAdapter
import com.example.countriesassignmentw.viewmodel.CountriesViewModel
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val countryViewModel : CountriesViewModel by lazy{
        ViewModelProvider(this, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CountriesViewModel() as T
            }
        })[CountriesViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.countiesView.layoutManager = LinearLayoutManager(this)
        setContentView(binding.root)

        countryViewModel.countries.observe(this) { state ->
            when (state) {
                is CountryResponseState.SUCCESS -> {
                    attachToAdapter(state.countries)
                }
                is CountryResponseState.ERROR -> {
                    Snackbar.make(binding.root, state.error.localizedMessage, Snackbar.LENGTH_LONG).show()
                }
            }

        }
    }

    private fun attachToAdapter(dataset: List<CountryInformation>) {
        val countryItemAdapter = CountryItemAdapter(dataset.map {
            CountryInformation(
                name = it.name,
                region = it.region,
                code = it.code,
                capital = it.capital
            )
        })

        binding.countiesView.adapter = countryItemAdapter
    }
}