package com.example.robotpath_adventure.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "progress",
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE)
    ]
)
data class Progress(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int, // Links progress to a specific kid
    val level: Int, // Current level
    val score: Int, // Score in the current level
    val date: Long // Timestamp of the progress entry
)
