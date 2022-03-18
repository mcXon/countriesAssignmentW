package com.example.countriesassignmentw.model

import retrofit2.Response
import retrofit2.http.GET

interface ICountryAPI {
    @GET(ENDPOINT)
    suspend fun getCountries() : Response<List<CountryInformation>>
}