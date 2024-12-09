package com.example.robotpath_adventure.data



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgress(progress: Progress)

    @Query("SELECT * FROM progress WHERE kidId = :kidId ORDER BY date DESC")
    fun getProgressForKid(kidId: Int): Flow<List<Progress>>
}
