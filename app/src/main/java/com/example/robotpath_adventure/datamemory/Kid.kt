package com.example.robotpath_adventure.datamemory

data class Kid(
    val id: Int, // Unique identifier for the kid
    val parentEmail: String, // Links to the parent
    val name: String,
    val kidID: String,
    val age: Int,
    val password: String,
)