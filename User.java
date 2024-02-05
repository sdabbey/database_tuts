import java.sql.*;

// User class representing a user entity
class User {
    private String username;
    private String email;

    // Constructor
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

// UserRepository class for data abstraction
class UserRepository {
    // JDBC connection details (replace with your actual database connection details)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    // Method to save a user to the database
    public void saveUser(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
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

    // Method to retrieve a user from the database by username
    public User getUserByUsername(String username) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
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
}

public class Main {
    public static void main(String[] args) {
        // Creating a user
        User newUser = new User("john_doe", "john.doe@example.com");

        // Creating a UserRepository instance for data abstraction
        UserRepository userRepository = new UserRepository();

        // Saving the user to the database
        userRepository.saveUser(newUser);

        // Retrieving the user from the database by username
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
