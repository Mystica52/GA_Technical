package com.example.mykotlinapp.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.mykotlinapp.data.AppDatabase

class FarmersViewModel(application: Application) : AndroidViewModel(application) {
    private val db: AppDatabase
    private val farmerDao: FarmersDao

    init {
        try {
            db = AppDatabase.getDatabase(application)
            farmerDao = db.farmerDao()
        } catch (e: Exception) {
            Log.e("FarmersViewModel", "Database init error: ${e.message}")
            throw e
        }
    }

    val allFarmers: LiveData<List<Farmer>> by lazy {
        farmerDao.getAllFarmers()
    }

    fun insertFarmer(farmer: Farmer) {
        viewModelScope.launch(Dispatchers.IO) {
            farmerDao.insertFarmer(farmer)
        }
    }
}




class FarmersViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FarmersViewModel::class.java)) {
            return FarmersViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
