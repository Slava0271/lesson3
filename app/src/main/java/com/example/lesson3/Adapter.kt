package com.example.lesson3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout.view.*

class Adapter(private val context: Context) :
        RecyclerView.Adapter<Adapter.PageHolder>() {

    inner class PageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder =
            PageHolder(LayoutInflater.from(context).inflate(R.layout.layout, parent, false))


    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        //holder.textView.text = words[position]
    }

    override fun getItemCount(): Int = 3
    //words.size

}
