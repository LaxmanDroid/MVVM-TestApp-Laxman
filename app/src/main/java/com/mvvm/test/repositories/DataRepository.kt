package com.mvvm.test.repositories

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mvvm.test.api.ApiClient
import com.mvvm.test.models.CountriesResponse
import com.mvvm.test.models.CountriesResponseItem
import com.mvvm.test.utils.Utility.showProgressBar
import com.mvvm.test.utils.Utility.hideProgressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataRepository {

    fun getMutableLiveDataa(context: Context) : MutableLiveData<ArrayList<CountriesResponseItem>>{

        val mutableLiveData = MutableLiveData<ArrayList<CountriesResponseItem>>()

        context.showProgressBar()

        ApiClient.apiService.getCountries().enqueue(object : Callback<CountriesResponse> {
            override fun onResponse(
                call: Call<CountriesResponse>,
                response: Response<CountriesResponse>
            ) {
                hideProgressBar()
                val countriesResponse = response.body() as CountriesResponse
                countriesResponse?.let { mutableLiveData.value = it as ArrayList<CountriesResponseItem> }
            }

            override fun onFailure(call: Call<CountriesResponse>, t: Throwable) {
                hideProgressBar()
                Log.e("error", t.localizedMessage)
            }


        })

        return mutableLiveData
    }

}