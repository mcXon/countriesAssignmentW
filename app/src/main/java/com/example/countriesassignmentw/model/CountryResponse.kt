package com.example.countriesassignmentw.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryInformation(
    val name : String,
    val region : String,
    val code : String,
    val capital : String
    ) : Parcelable

