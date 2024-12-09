package com.example.robotpath_adventure.ViewModels//package com.example.robotpath_adventure.ViewModels
//
//import com.example.robotpath_adventure.data.User
//import com.example.robotpath_adventure.data.UserRepository
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.viewModelScope
//import androidx.lifecycle.viewmodel.CreationExtras
//import com.example.robotpath_adventure.data.UserDao
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//
//class RegistrationViewModel(private val userRepository: UserRepository) : ViewModel() {
//
//    sealed class RegistrationState {
//        object Idle : RegistrationState()
//        object Success : RegistrationState()
//        data class Error(val message: String) : RegistrationState()
//    }
//
//    private val _registrationState = MutableStateFlow<RegistrationState>(RegistrationState.Idle)
//    val registrationState: StateFlow<RegistrationState> = _registrationState
//
//    // Register a Parent
//    fun registerParent(name: String, email: String, password: String) {
//        viewModelScope.launch {
//            try {
//                val parent = User(
//                    name = name,
//                    email = email,
//                    password = password,
//                    role = "parent"
//                )
//                userRepository.addUser(parent)
//                _registrationState.value = RegistrationState.Success
//            } catch (e: Exception) {
//                _registrationState.value = RegistrationState.Error("Error: ${e.message}")
//            }
//        }
//    }
//
//    // Register a Kid
//    fun registerKid(email: String, name: String, kidID: String, password: String, age: Int) {
//        viewModelScope.launch {
//            try {
//                val kid = User(
//                    name = name,
//                    email = email,
//                    kidID = kidID,
//                    password = password,
//                    age = age,
//                    role = "kid"
//                )
//                userRepository.addUser(kid)
//                _registrationState.value = RegistrationState.Success
//            } catch (e: Exception) {
//                _registrationState.value = RegistrationState.Error("Error: ${e.message}")
//            }
//        }
//    }
//
//    companion object {
//        fun provideFactory(userRepository: UserRepository): ViewModelProvider.Factory {
//            return object : ViewModelProvider.Factory {
//                @Suppress("UNCHECKED_CAST")
//                override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                    if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)) {
//                        return RegistrationViewModel(userRepository) as T
//                    }
//                    throw IllegalArgumentException("Unknown ViewModel class")
//                }
//            }
//        }
//    }
//}
