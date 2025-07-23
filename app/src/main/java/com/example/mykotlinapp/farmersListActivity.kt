package com.example.mykotlinapp

import com.example.mykotlinapp.data.FarmerAdapter
import com.example.mykotlinapp.data.FarmersViewModel


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FarmersListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FarmerAdapter
    private lateinit var viewModel: FarmersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.showallfarmers)

        recyclerView = findViewById(R.id.rv_farmers_table)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = FarmerAdapter()
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[FarmersViewModel::class.java]
        viewModel.allFarmers.observe(this) { farmers ->
            adapter.submitList(farmers)
        }
    }
}
