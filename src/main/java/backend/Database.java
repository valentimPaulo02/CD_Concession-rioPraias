package backend;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
	
    private Connection connection;
    private String jdbcUrl = "jdbc:mysql://aws.connect.psdb.cloud/cd_project?sslMode=VERIFY_IDENTITY";
    private String username = "tdl1y6upwo3shau53djr";
    private String password = "pscale_pw_DxyxF21qIQHDnDsgh3WtlLrrlHalUo1wPIVpJFHY802";
	// A PASSWORD É ESTA SEM OS TRAÇOS QUE ESTÃO NO INICIO FIM E MEIO
    
    public Database() {
    	
    }
    
    public void connect() throws SQLException {
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

    public List<Map<String, Object>> executeQueryGetData(String query, Map<Integer, Object> parameters) throws SQLException {
        if (connection == null || connection.isClosed()) {
            throw new SQLException("Database connection is not established.");
        }
        
        List<Map<String, Object>> resultList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
          
            for (Map.Entry<Integer, Object> entry : parameters.entrySet()) {
                preparedStatement.setObject(entry.getKey(), entry.getValue());
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
         
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (resultSet.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object value = resultSet.getObject(i);
                        row.put(columnName, value);
                    }
                    resultList.add(row);
                }
            }
        }
        return resultList;
    }
    
    public int executeQueryUpdateData(String query, Map<Integer, Object> parameters) throws SQLException {
        if (connection == null || connection.isClosed()) {
            throw new SQLException("Database connection is not established.");
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Map.Entry<Integer, Object> entry : parameters.entrySet()) {
                preparedStatement.setObject(entry.getKey(), entry.getValue());
            }

            return preparedStatement.executeUpdate();
        }
    }
	
}
