package com.example.robotpath_adventure.data


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parent_access_log")
data class ParentAccessLog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val parentId: Int, // Parent viewing the log
    val kidId: Int, // Kid whose progress was viewed
    val accessedAt: Long // Timestamp of the access
)
