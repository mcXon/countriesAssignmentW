package com.example.countriesassignmentw.common

import com.example.countriesassignmentw.model.CountryInformation

sealed class CountryResponseState {
    class SUCCESS(val countries: List<CountryInformation>) : CountryResponseState()
    class ERROR(val error: Throwable) : CountryResponseState()
}
