package backend;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.*;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {

  public ServerImplementation() throws RemoteException {
  }
  
  
  public ArrayList<Service> listarSombrinhas(String beach_id, String date, int start_time, int ending_time) throws RemoteException {
	  
	  Database db = new Database();
	  ArrayList<Service> services = new ArrayList<>();
	  
	  try {
		  db.connect();
		  
		  String query1 = "SELECT * FROM Service WHERE beach_id=?";
		  Map<Integer, Object> parameters1 = Map.of(1, beach_id);
		  
		  List<Map<String, Object>> allServices = db.executeQueryGetData(query1, parameters1);
		  // GET ALL SERVICES FROM BEACH -> beach_id
		  
		  String query2 = "SELECT * FROM Booking WHERE beach_id=? AND date=?";
		  Map<Integer, Object> parameters2 = Map.of(1, beach_id, 2, date);
		  
		  List<Map<String, Object>> allBookings = db.executeQueryGetData(query2, parameters2);
		  // GET ALL BOOKINGS FROM DATE -> date
		  
		  
		  //System.out.println(allServices);
		  boolean available;
		  
		  for (int x = 0; x < allServices.size(); x++) {
			    Map<String, Object> service = allServices.get(x);
			    String serviceId = (String) service.get("service_id");
			    String beachId = (String) service.get("beach_id");
			    int NbrOfSeats = (int) service.get("nbr_of_sits");
			    
			    available = true;
			    
			    if(allBookings.size()!=0) {
			    	for(int y = 0; y < allBookings.size(); y++) {
				    	Map<String, Object> booking = allBookings.get(y);
				    	String bookingServId = (String) booking.get("service_id");
				    	int bookingStartTime = (int) booking.get("start_time");
				    	int bookingEndingTime = (int) booking.get("ending_time");
				    	
				    	if(serviceId.equals(bookingServId)) {
				    		if((start_time >= bookingStartTime && start_time <= bookingEndingTime-1) 
				    				|| (ending_time >= bookingStartTime+1 && ending_time <= bookingEndingTime)) {
				    			available = false;
				    			break;
				    		}
				    	}
				    }
			    }
			    
			    if(available) {
			    	Service availableService = new Service(serviceId, beachId, NbrOfSeats);
			    	services.add(availableService);	    	
			    }
		  }

	  }catch (SQLException e) {
		  e.printStackTrace();
	  }finally {
		  try {
			  db.disconnect();
		  }catch (SQLException e){
			  e.printStackTrace();
		  }
	  }
	   
	  return services;
  }
  
  
  //AUX FUNCTION FOR MANDITORY FUNCTION -> CancelarReserva
  public ArrayList<Booking> listarReservas(int user_id) throws RemoteException {
	  
	  Database db = new Database();
	  ArrayList<Booking> bookings = new ArrayList<>();
	  
	  try {
		  db.connect();
		  
		  String query = "SELECT * FROM Booking WHERE user_id=?";
		  Map<Integer, Object> parameters = Map.of(1, user_id);
		  
		  List<Map<String, Object>> allBookings = db.executeQueryGetData(query, parameters);
		  // GET ALL BOOKINGS FROM USER -> user_id
	
		  if(allBookings.size() > 0) {
			  for (int x = 0; x < allBookings.size(); x++) {
				    Map<String, Object> booking = allBookings.get(x);
				    int bookingId = (int) booking.get("booking_id");
				    String serviceId = (String) booking.get("service_id");
				    Date date = (Date) booking.get("date");
				    int startTime = (int) booking.get("start_time");
				    int endTime = (int) booking.get("ending_time");
				    
				    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				    String dateString = dateFormat.format(date);
				    
				
			    	Booking userBooking = new Booking(bookingId, serviceId, dateString, startTime, endTime);
			    	bookings.add(userBooking);	    	
			  }
		  }	  

	  }catch (SQLException e) {
		  e.printStackTrace();
	  }finally {
		  try {
			  db.disconnect();
		  }catch (SQLException e){
			  e.printStackTrace();
		  }
	  }
	   
	  return bookings;
  }
  
  
  public int cancelarSombrinha(int booking_id) throws RemoteException {
	  
	  Database db = new Database();
	  int affectedRows=0;
	  
	  try {
		  db.connect();
		  
		  String query = "DELETE FROM Booking WHERE booking_id=?";
		  Map<Integer, Object> parameters = Map.of(1, booking_id);
		  
		  affectedRows = db.executeQueryUpdateData(query, parameters);
		  // DELETE BOOKING FROM A USER -> booking_id

	  }catch (SQLException e) {
		  e.printStackTrace();
	  }finally {
		  try {
			  db.disconnect();
		  }catch (SQLException e){
			  e.printStackTrace();
		  }
	  }
	  
	  return affectedRows;
  }
  
  
  public int reservarSombrinha(int user_id, String beach_id, String service_id, String date, int start_time, int ending_time) throws RemoteException {
	  
	  Database db = new Database();
	  int nbrOfPeople=0;
	  
	  try {
		  db.connect();
		  
		  String query1 = "INSERT INTO Booking (user_id, beach_id, service_id, date, start_time, ending_time) VALUES (?,?,?,?,?,?)";
		  Map<Integer, Object> parameters1 = Map.of(1, user_id, 2, beach_id, 3, service_id, 4, date, 5, start_time, 6, ending_time);
		  
		  int dummy = db.executeQueryUpdateData(query1, parameters1);
		  // INSERT BOOKING FROM A USER -> user_id
		  
		  String query2 = "SELECT * FROM Service WHERE service_id=?";
		  Map<Integer, Object> parameters2 = Map.of(1, service_id);
		  
		  List<Map<String, Object>> serviceUsed = db.executeQueryGetData(query2, parameters2);
		  // GET SITS FROM THE SERVICE
		  
		  Map<String, Object> service = serviceUsed.get(0);
		    nbrOfPeople = (int) service.get("nbr_of_sits");
		  

	  }catch (SQLException e) {
		  e.printStackTrace();
	  }finally {
		  try {
			  db.disconnect();
		  }catch (SQLException e){
			  e.printStackTrace();
		  }
	  }
	  
	  return nbrOfPeople;
  }
  
  
  
  
  
  
  
  

  
}
