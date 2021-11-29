package com.mvvm.test.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.test.R
import com.mvvm.test.models.CountriesResponseItem

class RecyclerAdapter(private val context: Context, private var list: MutableList<CountriesResponseItem>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list.get(position)
        holder.id?.text = data.id.toString()
        holder.country?.text = data.countryName

    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        var id: AppCompatTextView? = null
        var country:AppCompatTextView? = null


        init {
            id = view.findViewById(R.id.tv_id)
            country = view.findViewById(R.id.tv_country)
        }

    }

}