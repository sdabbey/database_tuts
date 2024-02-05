import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteExample {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:test.db";

        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            System.out.println("Connected to the SQLite database!");

            // Create a table
            createTable(connection);

            // Insert some data
            insertData(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
                "email TEXT NOT NULL)";
        
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        String insertDataSQL = "INSERT INTO users (username, email) VALUES (?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setString(1, "john_doe");
            statement.setString(2, "john.doe@example.com");
            statement.executeUpdate();
        }
    }
}
