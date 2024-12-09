package com.example.robotpath_adventure.datamemory


class ProgressRepository {
    private val progressList = mutableListOf<Progress>()

    fun addProgress(progress: Progress) {
        progressList.add(progress)
    }

    fun getProgressForKid(kidId: Int): List<Progress> {
        return progressList.filter { it.kidId == kidId }
    }
}
