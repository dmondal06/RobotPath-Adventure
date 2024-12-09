package com.example.robotpath_adventure.datamemory


class KidRepository {
    private val kids = mutableListOf<Kid>()
    private var nextId = 1

    fun addKid(kid: Kid): Kid {
        val kidWithId = kid.copy(id = nextId++)
        kids.add(kidWithId)
        return kidWithId
    }

    fun getKidsByParentEmail(parentEmail: String): List<Kid> {
        return kids.filter { it.parentEmail == parentEmail }
    }

    fun deleteKid(id: Int) {
        kids.removeIf { it.id == id }
    }
}
