package client;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import objects.*;

public class InterfaceRestHelper {
	
	public static ArrayList<String> listarSombrinhas(String beachId, int startTime, int endingTime, String date) throws JSONException {
		ArrayList<String> serviceIds = new ArrayList<>();
		
		try {
			URL url = new URL("http://localhost:8080/CD_Project/rest/LISTAR_SOMBRINHAS");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"Booking\":{"
					+ "\"beachId\":\""+beachId+"\","
					+ "\"date\":\""+date+"\","
					+ "\"startTime\":\""+startTime+"\","
					+ "\"endingTime\":\""+endingTime+"\""
					+ "}}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			Scanner scanner;
		    if (conn.getResponseCode() != 200) {
		    	  scanner = new Scanner(conn.getErrorStream());
		    } else {
		    	  scanner = new Scanner(conn.getInputStream());
		    }
	      	scanner.useDelimiter("\\Z");
	      	
	      	String jsonResponse = scanner.next();
	      	JSONObject jsonObject = new JSONObject(jsonResponse);
	        JSONArray serviceArray = jsonObject.getJSONArray("Service");

	        // Iterate through the array and print the information
	        for (int i = 0; i < serviceArray.length(); i++) {
	            JSONObject object = serviceArray.getJSONObject(i);
	            String id = object.getString("id");
	            int nbrOfSeats = object.getInt("nbrOfSeats");
	            
	            System.out.println("Id da Sombrinha: "+id+" | Lugares: "+nbrOfSeats);
	            serviceIds.add(id);
	        }
	      	
	      	scanner.close();
	      	conn.disconnect();
	      
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return serviceIds;
	}

	public static int reservarSombrinhas(String beachId, int startTime, int endingTime, String date, int userId, String service) throws JSONException {

		int nbrOfPeople=0;
		
		try {
			URL url = new URL("http://localhost:8080/CD_Project/rest/RESERVAR_SOMBRINHA");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"Booking\":{"
					+ "\"beachId\":\""+beachId+"\","
					+ "\"date\":\""+date+"\","
					+ "\"startTime\":\""+startTime+"\","
					+ "\"userId\":\""+userId+"\","
					+ "\"endingTime\":\""+endingTime+"\","
					+ "\"serviceId\":\""+service+"\""
					+ "}}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			Scanner scanner;
		    if (conn.getResponseCode() != 200) {
		    	  scanner = new Scanner(conn.getErrorStream());
		    } else {
		    	  scanner = new Scanner(conn.getInputStream());
		    }
	      	scanner.useDelimiter("\\Z");
	      	
	      	nbrOfPeople += Integer.parseInt(scanner.next());
	      	
	      	scanner.close();
	      	conn.disconnect();
	      
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return nbrOfPeople;
	}
	
	public static ArrayList<Integer> listarReservas(int userId) throws JSONException {
		
		ArrayList<Integer> bookingIds = new ArrayList<>();
		
		try {
			URL url = new URL("http://localhost:8080/CD_Project/rest/LISTAR_RESERVAS");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"User\":{"
					+ "\"id\":\""+userId+"\""
					+ "}}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			Scanner scanner;
		    if (conn.getResponseCode() != 200) {
		    	  scanner = new Scanner(conn.getErrorStream());
		    } else {
		    	  scanner = new Scanner(conn.getInputStream());
		    }
	      	scanner.useDelimiter("\\Z");
	      	
	      	String jsonResponse = scanner.next();
	      	JSONObject jsonObject = new JSONObject(jsonResponse);
	        JSONArray serviceBooking = jsonObject.getJSONArray("Booking");

	        // Iterate through the array and print the information
	        for (int i = 0; i < serviceBooking.length(); i++) {
	            JSONObject booking = serviceBooking.getJSONObject(i);
	            int id = booking.getInt("id");
	            int startTime = booking.getInt("startTime");
	            int endingTime = booking.getInt("endingTime");
	            String date = booking.getString("date");
	            String serviceId = booking.getString("serviceId");
	            
	            System.out.println("Id da Reserva: "+id+" | Id da Sombrinha: "+serviceId+" | "+date+" das "+startTime+" às "+endingTime);
	            bookingIds.add(id);
	        }
	      	
	      	scanner.close();
	      	conn.disconnect();
	      
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bookingIds;
	}
	
	public static void cancerlarReserva(int bookingId) throws JSONException {
		try {
			URL url = new URL("http://localhost:8080/CD_Project/rest/CANCELAR_SOMBRINHA");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"Booking\":{"
					+ "\"id\":\""+bookingId+"\""
					+ "}}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			Scanner scanner;
		    if (conn.getResponseCode() != 200) {
		    	  scanner = new Scanner(conn.getErrorStream());
		    } else {
		    	  scanner = new Scanner(conn.getInputStream());
		    }
	      	scanner.useDelimiter("\\Z");
	      	
	      	System.out.println(scanner.next());
	      	
	      	scanner.close();
	      	conn.disconnect();
	      
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int login(String username, String password) throws JSONException {
		int value = -1;
		
		try {
			URL url = new URL("http://localhost:8080/CD_Project/rest/LOGIN");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"User\":{"
					+ "\"username\":\""+username+"\","
					+ "\"password\":\""+password+"\""
					+ "}}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			Scanner scanner;
		    if (conn.getResponseCode() != 200) {
		    	  scanner = new Scanner(conn.getErrorStream());
		    } else {
		    	  scanner = new Scanner(conn.getInputStream());
		    }
	      	scanner.useDelimiter("\\Z");
	      	
	      	value = Integer.parseInt(scanner.next().trim());
	      	
	      	scanner.close();
	      	conn.disconnect();
	      
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static boolean registarUtilizador(String username, String password) throws JSONException {
		boolean valid = true;
		
		try {
			URL url = new URL("http://localhost:8080/CD_Project/rest/REGISTAR_UTILIZADOR");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"User\":{"
					+ "\"username\":\""+username+"\","
					+ "\"password\":\""+password+"\""
					+ "}}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			Scanner scanner;
		    if (conn.getResponseCode() != 200) {
		    	  scanner = new Scanner(conn.getErrorStream());
		    } else {
		    	  scanner = new Scanner(conn.getInputStream());
		    }
	      	scanner.useDelimiter("\\Z");
	      	
	      	valid = Boolean.parseBoolean(scanner.next().trim());
	      	
	      	scanner.close();
	      	conn.disconnect();
	      
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return valid;
	}
}
