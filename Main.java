import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

class UserRepository {
    private static final String JDBC_URL = "jdbc:sqlite:test.db";

    public void saveUser(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            createTable(connection);

            String insertQuery = "INSERT INTO users (username, email) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByUsername(String username) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            createTable(connection);

            String selectQuery = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new User(resultSet.getString("username"), resultSet.getString("email"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
                "email TEXT NOT NULL)";
        
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a user
        User newUser = new User("john_doe", "john.doe@example.com");

        // Creating a UserRepository instance for data abstraction
        UserRepository userRepository = new UserRepository();

        // Saving the user to the SQLite database
        userRepository.saveUser(newUser);

        // Retrieving the user from the SQLite database by username
        User retrievedUser = userRepository.getUserByUsername("john_doe");

        // Displaying the retrieved user's information
        if (retrievedUser != null) {
            System.out.println("Retrieved User:");
            System.out.println("Username: " + retrievedUser.getUsername());
            System.out.println("Email: " + retrievedUser.getEmail());
        } else {
            System.out.println("User not found.");
        }
    }
}
