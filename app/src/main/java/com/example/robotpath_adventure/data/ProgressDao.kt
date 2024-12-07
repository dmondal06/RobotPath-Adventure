package com.example.robotpath_adventure.data


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ProgressDao {
    @Insert
    suspend fun insertProgress(progress: Progress)

    @Query("SELECT * FROM progress WHERE userId = :userId ORDER BY date DESC")
    fun getProgressForKid(userId: Int): Flow<List<Progress>>
}
