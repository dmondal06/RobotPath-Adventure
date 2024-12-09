package com.example.robotpath_adventure.ViewModels
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.viewModelScope
//import com.example.robotpath_adventure.data.User
//import com.example.robotpath_adventure.data.UserRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.flow.stateIn
//import kotlinx.coroutines.launch
//
//class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
//
//    sealed class UserState {
//        object Idle : UserState()
//        object Success : UserState()
//        data class Error(val message: String) : UserState()
//        data class KidsLoaded(val kids: List<User>) : UserState()
//    }
//
//    private val _userState = MutableStateFlow<UserState>(UserState.Idle)
//    val userState: StateFlow<UserState> = _userState
//
//    // Add a parent to the database
//    fun addParent(name: String, email: String, password: String) {
//        viewModelScope.launch {
//            try {
//                val parent = User(
//                    name = name,
//                    email = email,
//                    password = password,
//                    role = "parent"
//                )
//                userRepository.addUser(parent)
//                _userState.value = UserState.Success
//            } catch (e: Exception) {
//                _userState.value = UserState.Error("Error adding parent: ${e.message}")
//            }
//        }
//    }
//
//    // Add a kid to the database
//    fun addKid(email: String, name: String, password: String, age: Int, kidID: String) {
//        viewModelScope.launch {
//            try {
//                val kid = User(
//                    name = name,
//                    email = email, // Use parent's email to link the kid
//                    password = password,
//                    role = "kid",
//                    kidID = kidID,
//                    age = age
//                )
//                userRepository.addUser(kid)
//                _userState.value = UserState.Success
//            } catch (e: Exception) {
//                _userState.value = UserState.Error("Error adding kid: ${e.message}")
//            }
//        }
//    }
//
//    // Parent login
//    fun loginParent(email: String, password: String) {
//        viewModelScope.launch {
//            try {
//                val user = userRepository.loginParent(email, password)
//                if (user != null) {
//                    _userState.value = UserState.Success
//                } else {
//                    _userState.value = UserState.Error("Invalid email or password")
//                }
//            } catch (e: Exception) {
//                _userState.value = UserState.Error("Error logging in as parent: ${e.message}")
//            }
//        }
//    }
//
//    // Kid login
//    fun loginKid(kidID: String, password: String) {
//        viewModelScope.launch {
//            try {
//                val user = userRepository.loginKid(kidID, password)
//                if (user != null) {
//                    _userState.value = UserState.Success
//                } else {
//                    _userState.value = UserState.Error("Invalid Kid ID or password")
//                }
//            } catch (e: Exception) {
//                _userState.value = UserState.Error("Error logging in as kid: ${e.message}")
//            }
//        }
//    }
//
//    // Get kids linked to a parent
//    fun getKidsForParent(email: String) {
//        viewModelScope.launch {
//            try {
//                userRepository.getKidsForParent(email).collect { kids ->
//                    _userState.value = UserState.KidsLoaded(kids)
//                }
//            } catch (e: Exception) {
//                _userState.value = UserState.Error("Error fetching kids: ${e.message}")
//            }
//        }
//    }
//
//    companion object {
//        fun provideFactory(userRepository: UserRepository): ViewModelProvider.Factory {
//            return object : ViewModelProvider.Factory {
//                @Suppress("UNCHECKED_CAST")
//                override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                    if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
//                        return UserViewModel(userRepository) as T
//                    }
//                    throw IllegalArgumentException("Unknown ViewModel class")
//                }
//            }
//        }
//    }
//}
