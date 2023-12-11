package backend;
import java.sql.*;
import java.util.Map;

public class Database {
	
	private Connection connection;
    private String jdbcUrl = "jdbc:mysql://aws.connect.psdb.cloud/cd_project?sslMode=VERIFY_IDENTITY";
    private String username = "8fcpk2l571ttfuetcc7z";
    private String password = "pscale_pw_oJpbrXezCuqRs6iPVTNSN7HX3eJzFA5tupFkdOjBE5m";
    
    public Database() throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        connection = DriverManager.getConnection(jdbcUrl, username, password);
    }
    
    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public ResultSet executeQueryWithData(String query, Map<Integer, Object> parameters) throws SQLException {
        if (connection == null || connection.isClosed()) {
            throw new SQLException("Database connection is not established.");
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set parameters for the prepared statement
            for (Map.Entry<Integer, Object> entry : parameters.entrySet()) {
                preparedStatement.setObject(entry.getKey(), entry.getValue());
            }

            // Execute the query
            return preparedStatement.executeQuery();
        }
    }
	
}
