package com.mvvm.test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.test.R
import com.mvvm.test.adapters.RecyclerAdapter
import com.mvvm.test.models.CountriesResponseItem
import com.mvvm.test.viewmodels.MainViewModel
import com.mvvm.test.viewmodelsfactories.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var countiesList: MutableList<CountriesResponseItem>
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_main.layoutManager = LinearLayoutManager(this@MainActivity)
        countiesList = mutableListOf<CountriesResponseItem>()
        adapter = RecyclerAdapter(this,
            countiesList
        )
        recycler_main.adapter = adapter

        val userViewModel = ViewModelProviders.of(this,ViewModelFactory(this)).get(MainViewModel::class.java)

        btn_fetch.setOnClickListener {
            userViewModel.getCountiesData().observe(this,object:Observer<ArrayList<CountriesResponseItem>>{
                override fun onChanged(t: ArrayList<CountriesResponseItem>?) {
                    countiesList.clear()
                    t?.let { countiesList.addAll(it) }
                    adapter.notifyDataSetChanged()
                }

            })
        }



    }
}
