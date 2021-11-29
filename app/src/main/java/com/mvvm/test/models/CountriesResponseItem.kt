package com.mvvm.test.models

import com.google.gson.annotations.SerializedName

data class CountriesResponseItem(
    @SerializedName("countryName")
    val countryName: String,

    @SerializedName("id")
    val id: Int
)