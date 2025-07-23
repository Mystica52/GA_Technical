package com.example.mykotlinapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapp.data.Farmer
import com.example.mykotlinapp.data.FarmerAdapter
import com.example.mykotlinapp.data.FarmersViewModel
import com.example.mykotlinapp.data.FarmersViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: FarmersViewModel
    private lateinit var adapter: FarmerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.showallfarmers)

        adapter = FarmerAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.rv_farmers_table)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(
            this,
            FarmersViewModelFactory(application)
        )[FarmersViewModel::class.java]

        viewModel.allFarmers.observe(this) { farmers ->
            adapter.submitList(farmers)
        }

        findViewById<Button>(R.id.btn_add_farmer).setOnClickListener {
            startActivity(Intent(this, AddFarmerActivity::class.java))
        }
    }
}





