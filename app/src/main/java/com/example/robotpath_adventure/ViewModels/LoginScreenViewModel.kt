package com.example.robotpath_adventure.ViewModels//package com.example.robotpath_adventure.ViewModels
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.viewModelScope
//import com.example.robotpath_adventure.data.User
//import com.example.robotpath_adventure.data.UserRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class LoginViewModel<UserRepository>(private val userRepository: UserRepository) : ViewModel() {
////
////    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
////    val loginState: StateFlow<LoginState> = _loginState
////
////    fun loginParent(email: String, password: String, onSuccess: (User) -> Unit) {
////        viewModelScope.launch {
////            val user = userRepository.loginParent(email, password)
////            if (user != null) {
////                // Pass the logged-in user object to the onSuccess callback
////                onSuccess(user)
////            } else {
////                // Login failed
////                _loginState.value = LoginState.Error("Invalid credentials for Parent login.")
////            }
////        }
////    }
////
////
////    fun loginKid(kidID: String, password: String, onSuccess: (User) -> Unit) {
////        viewModelScope.launch {
////            val user = userRepository.loginKid(kidID, password)
////            if (user != null) {
////                onSuccess(user)
////            } else {
////                _loginState.value = LoginState.Error("Invalid credentials for Kid login.")
////            }
////        }
////    }
////
////    sealed class LoginState {
////        object Idle : LoginState()
////        object Success : LoginState()
////        data class Error(val message: String) : LoginState()
////    }
////
////    companion object {
////        fun provideFactory(userRepository: UserRepository): ViewModelProvider.Factory {
////            return object : ViewModelProvider.Factory {
////                @Suppress("UNCHECKED_CAST")
////                override fun <T : ViewModel> create(modelClass: Class<T>): T {
////                    if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
////                        return LoginViewModel(userRepository) as T
////                    }
////                    throw IllegalArgumentException("Unknown ViewModel class")
////                }
////            }
////        }
//    }
//}
