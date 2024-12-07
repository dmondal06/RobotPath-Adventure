package com.example.robotpath_adventure.data


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ParentAccessLogDao {
    @Insert
    suspend fun insertLog(log: ParentAccessLog)

    @Query("SELECT * FROM parent_access_log WHERE parentId = :parentId ORDER BY accessedAt DESC")
    fun getLogsForParent(parentId: Int): Flow<List<ParentAccessLog>>
}
