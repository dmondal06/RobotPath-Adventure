package com.example.robotpath_adventure.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.robotpath_adventure.data.KidRepository
import com.example.robotpath_adventure.utils.ParentSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.robotpath_adventure.data.Kid
import com.example.robotpath_adventure.utils.ParentSession.email


class KidViewModel(private val kidRepository: KidRepository) : ViewModel() {

//    private val _kidsList = MutableStateFlow<List<Kid>>(emptyList())
//    val kidsList: StateFlow<List<Kid>> = _kidsList
//
//    init {
//        loadKids()
//    }
//
//    private fun loadKids() {
//        val email = ParentSession.email
//        if (email!= null) {
//            viewModelScope.launch {
//                kidRepository.getAllKidsByEmail(email).collect { kids ->
//                    _kidsList.value = kids
//                }
//            }
//        } else {
//            println("Error: Parent ID is null. Unable to load kids.")
//        }
//    }
//
//    fun addKid(kid: Kid) {
//        val email = ParentSession.email
//        if (email!= null) {
//            val kidWithEmail = kid.copy(email = email)
//            viewModelScope.launch {
//                kidRepository.insertKid(kidWithEmail)
//                loadKids() // Refresh the list after insertion
//            }
//        } else {
//            println("Error: Parent ID is null. Unable to add kid.")
//        }
//    }
//
//    fun updateKid(kid: Kid) {
//        viewModelScope.launch {
//            kidRepository.updateKid(kid)
//            loadKids() // Refresh the list after update
//        }
//    }
//
//    fun deleteKid(kidId: Int) {
//        viewModelScope.launch {
//            kidRepository.deleteKid(kidId)
//            loadKids() // Refresh the list after deletion
//        }
//    }
//
//
//    companion object {
//        fun provideFactory(kidRepository: KidRepository): ViewModelProvider.Factory {
//            return object : ViewModelProvider.Factory {
//                @Suppress("UNCHECKED_CAST")
//                override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                    if (modelClass.isAssignableFrom(KidViewModel::class.java)) {
//                        return KidViewModel(kidRepository) as T
//                    }
//                    throw IllegalArgumentException("Unknown ViewModel class")
//                }
//            }
//        }
//    }
}
