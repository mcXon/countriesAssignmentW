package com.example.countriesassignmentw.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesassignmentw.common.CountryResponseState
import com.example.countriesassignmentw.model.CountryRepository
import com.example.countriesassignmentw.model.CountryRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "CountriesViewModel"

class CountriesViewModel(
    private val repository: CountryRepository = CountryRepositoryImpl(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel(){

    private val _countries : MutableLiveData<CountryResponseState> by lazy {
        MutableLiveData<CountryResponseState>().also {
            getCountriesFromCall()
        }
    }
    val countries: LiveData<CountryResponseState> get() = _countries

    private fun getCountriesFromCall() {
        viewModelScope.launch(ioDispatcher) {
            try {
                val response = repository.getCountries()
                if(response.isSuccessful){
                    Log.d(TAG, "API call: ")
                    response.body()?.let {
                        _countries.postValue(CountryResponseState.SUCCESS(it))
                    } ?: throw Exception("Response is null")
                }else{
                    throw Exception("Failure response")
                }
            } catch (e: Exception) {
                _countries.postValue(CountryResponseState.ERROR(e))
            }
        }
    }
}