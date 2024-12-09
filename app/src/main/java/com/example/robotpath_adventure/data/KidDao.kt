package com.example.robotpath_adventure.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface KidDao {
    // Insert a kid, replacing if there's a conflict
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKid(kid: Kid)

    // Fetch all kids for a specific parent
    @Query("SELECT * FROM kids WHERE parentEmail = :parentEmail")
    fun getAllKidsByParentId(parentId: Int): Flow<List<Kid>>

    // Update a kid's details
    @Update
    suspend fun updateKid(kid: Kid)

    // Delete a kid by ID
    @Query("DELETE FROM kids WHERE id = :kidId")
    suspend fun deleteKid(kidId: Int)
}
