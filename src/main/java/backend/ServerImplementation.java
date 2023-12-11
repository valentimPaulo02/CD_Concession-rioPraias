package backend;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {

  public ServerImplementation() throws RemoteException {
  }
  
  public double add(double d1, double d2) throws RemoteException {
	  
	  try {
		  Database db = new Database();
		  
		  String query = "INSERT INTO Booking (booking_id, user_id, beach_id, service_id, date, start_time, ending_time)"
		  		+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		  Map<Integer, Object> parameters = new HashMap<>();
		  parameters.put(1, "2");
		  parameters.put(2, "1");
		  parameters.put(3, "A");
		  parameters.put(4, "A11");
		  parameters.put(5, "2023-06-17");
		  parameters.put(6, "8");
		  parameters.put(7, "9");
		  
		  ResultSet result = db.executeQueryWithData(query, parameters);
		  db.disconnect();
		  
	  }catch (SQLException e) {
		  e.printStackTrace();
	  }
	   
	  return d1 + d2;
  }
}
