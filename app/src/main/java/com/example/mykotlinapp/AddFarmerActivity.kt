package com.example.mykotlinapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mykotlinapp.data.Farmer
import com.example.mykotlinapp.data.FarmersViewModel

class AddFarmerActivity : AppCompatActivity() {

    private lateinit var viewModel: FarmersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recordfarmer)

        viewModel = ViewModelProvider(this)[FarmersViewModel::class.java]

        val etName = findViewById<EditText>(R.id.et_name)
        val etId = findViewById<EditText>(R.id.et_id_number)
        val etCrop = findViewById<EditText>(R.id.et_crop_type)
        val btnSave = findViewById<Button>(R.id.btn_save)

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val id = etId.text.toString().trim()
            val crop = etCrop.text.toString().trim()

            if (name.isNotEmpty() && id.isNotEmpty() && crop.isNotEmpty()) {
                val farmer = Farmer( name=name, nationalId = id, cropType = crop)
                viewModel.insertFarmer(farmer)
                Toast.makeText(this, "Farmer saved!", Toast.LENGTH_SHORT).show()
                finish() // go back to list
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
