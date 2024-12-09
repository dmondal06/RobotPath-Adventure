package com.example.robotpath_adventure.data



class KidRepository {
    private val kids = mutableListOf<Kid>() // In-memory kid list

    fun addKid(kid: Kid) {
        kids.add(kid)
    }

//    fun getKidsByParentEmail(email: String): List<Kid> {
//        return kids.filter { it.email == email }
//    }

    fun deleteKid(kidId: Int) {
        kids.removeIf { it.id == kidId }
    }
}

//
//import kotlinx.coroutines.flow.Flow
//
//
//
//class KidRepository(private val kidDao: KidDao) {
//
//    // Fetch all kids by parent ID
//    fun getAllKidsByParentId(parentId: Int): Flow<List<Kid>> {
//        return kidDao.getAllKidsByParentId(parentId)
//    }
//
//    // Insert a new kid
//    suspend fun insertKid(kid: Kid) {
//        kidDao.insertKid(kid)
//    }
//
//    // Update an existing kid
//    suspend fun updateKid(kid: Kid) {
//        kidDao.updateKid(kid)
//    }
//
//    // Delete a kid
//    suspend fun deleteKid(kidId: Int) {
//        kidDao.deleteKid(kidId)
//    }
//
//    fun getAllKids(): Any {
//
//    }
//}
