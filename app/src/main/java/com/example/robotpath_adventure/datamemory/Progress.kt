package com.example.robotpath_adventure.datamemory

data class Progress(
    val kidId: Int, // Links to the kid
    val level: Int, // Current level
    val score: Int, // Current score
    val timestamp: Long, // Timestamp for when this progress was recorded
)