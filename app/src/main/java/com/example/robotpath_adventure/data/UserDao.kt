import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    // Insert or replace a user in the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    // Retrieve a user by email and password for parent login
    @Query("SELECT * FROM users WHERE email = :email AND password = :password AND role = 'parent' LIMIT 1")
    suspend fun loginParent(email: String, password: String): User?

    // Retrieve a user by kid ID and password for kid login
    @Query("SELECT * FROM users WHERE kidID = :kidID AND password = :password AND role = 'kid' LIMIT 1")
    suspend fun loginKid(kidID: String, password: String): User?

    // Retrieve all kids linked to a specific parent email
    @Query("SELECT * FROM users WHERE email = :email AND role = 'kid'")
    fun getKidsForParent(email: String): Flow<List<User>>

    // Retrieve a user by email for any purpose
    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?
}
