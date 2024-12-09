package com.example.robotpath_adventure.data



import User
import UserDao
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [User::class, Kid::class, Progress::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun kidDao(): KidDao
    abstract fun progressDao(): ProgressDao
}
