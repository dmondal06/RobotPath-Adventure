package com.example.robotpath_adventure.datamemory

class ParentRepository {
    private val parents = mutableListOf<Parent>()

    fun addParent(parent: Parent) {
        parents.add(parent)
    }

    fun loginParent(email: String, password: String): Parent? {
        return parents.find { it.email == email && it.password == password }
    }
}