package backend;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {

  public ServerImplementation() throws RemoteException {
  }
  
  public double add(double d1, double d2) throws RemoteException {
	  
	  Database db = new Database();
	  
	  try {
		  db.connect();
		  
		  String query = "SELECT * FROM Booking";
		  Map<Integer, Object> parameters = Map.of();
		  
		  List<Map<String, Object>> result = db.executeQueryWithData(query, parameters);
		  System.out.println(result);

	  }catch (SQLException e) {
		  e.printStackTrace();
	  }finally {
		  try {
			  db.disconnect();
		  }catch (SQLException e){
			  e.printStackTrace();
		  }
	  }
	   
	  return d1 + d2;
  }
}
