package client;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import objects.*;
import frontend.soap.*;

public class InterfaceSoapHelper {
	
	private static final SoapServices soapHelper = initiateHelper();
	
	private static SoapServices initiateHelper() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:8080/CD_Project/SoapServicesImpPort");
		factory.setServiceClass(SoapServices.class);
		SoapServices client = (SoapServices) factory.create();
		return client;
	}
	
	public static ArrayList<String> listarSombrinhas(String beachId, int startTime, int endingTime, String date) {
		ArrayList<String> serviceIds = new ArrayList<>();
		Booking booking = new Booking(beachId, date, startTime, endingTime);
		
		try {
			ArrayList<Service> services = soapHelper.listarSombrinhas(booking);
			
			for(Service service : services) {
				serviceIds.add(service.getId());
				
				System.out.println("Id da Sombrinha: "+service.getId()+" | Lugares: "+service.getNbrOfSeats());
			}
	      
		} catch (SecurityException e) {
			e.printStackTrace();	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return serviceIds;
	}

	public static int reservarSombrinhas(String beachId, int startTime, int endingTime, String date, int userId, String service) throws JSONException {
		Booking booking = new Booking(userId, service, beachId, date, startTime, endingTime);
		
		try {
	      	return Integer.parseInt(soapHelper.reservarSombrinha(booking));
	      
		} catch (SecurityException e) {
			e.printStackTrace();	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public static ArrayList<Integer> listarReservas(int userId) {
		User user = new User(userId);
		ArrayList<Integer> bookingIds = new ArrayList<>();
		
		try {
			ArrayList<Booking> bookings = soapHelper.listarReservas(userId);
			
			for(Booking booking : bookings) {
				bookingIds.add(booking.getId());
				
				System.out.println("Id da Reserva: "+booking.getId()+
						" | Id da Sombrinha: "+booking.getServiceId()+" | "+booking.getDate()+
						" das "+booking.getStartTime()+" às "+booking.getEndingTime());
			}
		} catch (SecurityException e) {
			e.printStackTrace();	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return bookingIds;
	}
	
	public static void cancerlarReserva(int bookingId) {
		Booking booking = new Booking(bookingId);
		
		try {
			System.out.println(soapHelper.cancelarSombrinha(booking));
		} catch (SecurityException e) {
			e.printStackTrace();	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public static int login(String username, String password) {
		User user = new User(username, password);
		
		try {
			return Integer.parseInt(soapHelper.login(user).trim());
		} catch (SecurityException e) {
			e.printStackTrace();	
			return -1;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static boolean registarUtilizador(String username, String password) {
		User user = new User(username, password);
		
		try {
			return Boolean.parseBoolean(soapHelper.registarUtilizador(user).trim());
		} catch (SecurityException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}
}