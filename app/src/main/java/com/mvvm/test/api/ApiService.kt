package com.mvvm.test.api

import com.mvvm.test.models.CountriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("countries.json")
    fun getCountries(): Call<CountriesResponse>

}