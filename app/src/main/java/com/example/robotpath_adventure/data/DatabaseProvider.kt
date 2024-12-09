package com.example.robotpath_adventure.data

import android.content.Context
import androidx.room.Room


object DatabaseProvider {

    private var instance: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return instance ?: synchronized(this) {
            val newInstance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "robotpath_adventure.db"
            )
                .fallbackToDestructiveMigration() // This will reset the database
                .build()
            instance = newInstance
            newInstance
        }
    }
}
