package com.example.countriesassignmentw.common

import com.example.countriesassignmentw.model.BASE_URL
import com.example.countriesassignmentw.model.ICountryAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {

    val countryInformationAPI : ICountryAPI by lazy{
        initRetrofit().create(ICountryAPI::class.java)
    }

    private fun initRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}