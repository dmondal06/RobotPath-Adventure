package com.example.robotpath_adventure.data

import User
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "kids",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["parentEmail"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Kid(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val parentEmail: Int,
    val name: String,
    val kidID: String,
    val age: Int,
    val password: String
)
