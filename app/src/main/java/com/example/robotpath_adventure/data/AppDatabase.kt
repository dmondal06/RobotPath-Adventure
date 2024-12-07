package com.example.robotpath_adventure.data


import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [User::class, Progress::class, ParentAccessLog::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun progressDao(): ProgressDao
    abstract fun parentAccessLogDao(): ParentAccessLogDao
}
