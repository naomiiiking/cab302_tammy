package Memorylogs;

import java.sql.*;

public class StudyLogsDAO {
    private Connection connection;

    public StudyLogsDAO() {
        // Initialize the database connection
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:MemoryLog.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createStudyLogsTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS StudyLogs (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "user_id INTEGER, " +
                            "date TEXT, " +
                            "hours_studied REAL, " +
                            "money_earned REAL, " +
                            "FOREIGN KEY (user_id) REFERENCES UserAccounts(id)" +
                            ")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertStudyLog(int userId, String date, String hoursStudied, int moneyEarned) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO StudyLogs (user_id, date, hours_studied, money_earned) VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, userId);
            statement.setString(2, date.toString());
            statement.setString(3, hoursStudied.toString());
            statement.setString(4, String.valueOf(moneyEarned));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
