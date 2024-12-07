package com.example.robotpath_adventure.ViewModels

import com.example.robotpath_adventure.data.User
import com.example.robotpath_adventure.data.UserRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _registrationState = MutableStateFlow<RegistrationState>(RegistrationState.Idle)
    val registrationState: StateFlow<RegistrationState> get() = _registrationState

    fun registerUser(name: String, email: String, password: String, role: String, parentId: Int? = null) {
        if (name.isBlank() || email.isBlank() || password.isBlank()) {
            _registrationState.value = RegistrationState.Error("All fields are required")
            return
        }

        viewModelScope.launch {
            val user = User(name = name, email = email, password = password, role = role, parentId = parentId)
            userRepository.addUser(user)
            _registrationState.value = RegistrationState.Success
        }
    }
}

//sealed class RegistrationState {
//    object Idle : RegistrationState()
//    object Success : RegistrationState()
//    data class Error(val message: String) : RegistrationState()
//}
