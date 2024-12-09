import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val email: String, // Set email as the primary key
    val name: String,
    val password: String,
    val role: String // "parent" or "kid"
)
