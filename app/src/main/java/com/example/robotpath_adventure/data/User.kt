package com.example.robotpath_adventure.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val email: String,
    val password: String,
    val role: String, // "kid" or "parent"
    val parentId: Int? = null // Links a kid to their parent (null for parents)
)
