package com.mvvm.test.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvm.test.models.CountriesResponseItem
import com.mvvm.test.repositories.DataRepository
import com.mvvm.test.utils.Utility.isInternetAvailable

class MainViewModel(private val context: Context) : ViewModel() {

    private var countriesListData = MutableLiveData<ArrayList<CountriesResponseItem>>()

    init{
        val userRepository : DataRepository by lazy {
            DataRepository
        }

        if(context.isInternetAvailable()) {
            countriesListData = userRepository.getMutableLiveDataa(context)
        }
    }

    fun getCountiesData() : MutableLiveData<ArrayList<CountriesResponseItem>>{
        return countriesListData
    }

}