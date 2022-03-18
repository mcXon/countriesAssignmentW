package com.example.countriesassignmentw.model

import com.example.countriesassignmentw.common.Network
import retrofit2.Response

class CountryRepositoryImpl : CountryRepository {

    override suspend fun getCountries(): Response<List<CountryInformation>> {
        return Network.countryInformationAPI.getCountries()
    }
}

interface CountryRepository {
    suspend fun getCountries() : Response<List<CountryInformation>>
}