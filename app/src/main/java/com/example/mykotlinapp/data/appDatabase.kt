package com.example.mykotlinapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Farmer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun farmerDao(): FarmersDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "farmer_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
