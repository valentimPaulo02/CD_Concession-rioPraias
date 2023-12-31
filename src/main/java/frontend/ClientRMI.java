package frontend;
import backend.*;
import objects.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class ClientRMI {
	
	public ClientRMI() {
	}
	
	public int reservarSombrinha(Booking booking) {
		try {
    	
	      Registry registry = LocateRegistry.getRegistry("192.168.111.129");
	      ServerInterface ServerIntf = (ServerInterface)registry.lookup("ServerFunctions");
	   
	      //retorna o numero de lugares do serviço escolhido
	      return ServerIntf.reservarSombrinha(
	    		  booking.getUserId(),
	    		  booking.getBeachId(),
	    		  booking.getServiceId(),
	    		  booking.getDate(),
	    		  booking.getStartTime(),
	    		  booking.getEndingTime()
	    		  );
		}
		catch(Exception e) {
			System.out.println("Exception: " + e);
			return -1;
		}
	}
	
	public int cancelarSombrinha(int bookingId) {
		try {
	    	
		      Registry registry = LocateRegistry.getRegistry("192.168.111.129");
		      ServerInterface ServerIntf = (ServerInterface)registry.lookup("ServerFunctions");
		   
		      //retorna o numero de linhas afetadas, deverias ser sempre 1
		      return ServerIntf.cancelarSombrinha(bookingId);
		}
		catch(Exception e) {
			System.out.println("Exception: " + e);
			return -1;
		}
	}
	
	public ArrayList<Service> listarSombrinhas(Booking booking){
		try {
	    	
		      Registry registry = LocateRegistry.getRegistry("192.168.111.129");
		      ServerInterface ServerIntf = (ServerInterface)registry.lookup("ServerFunctions");
		   
		      //retorna uma lista com os serviços disponiveis
		      return ServerIntf.listarSombrinhas(
		    		  booking.getBeachId(),
		    		  booking.getDate(),
		    		  booking.getStartTime(),
		    		  booking.getEndingTime()
		    		  );
		}
		catch(Exception e) {
			System.out.println("Exception: " + e);
			return new ArrayList<Service>();
		}
	}
	
	public ArrayList<Booking> listarReservas (int userId){
		try {
	    	
		      Registry registry = LocateRegistry.getRegistry("192.168.111.129");
		      ServerInterface ServerIntf = (ServerInterface)registry.lookup("ServerFunctions");
		   
		      //retorna uma lista com as reservas do utilizador
		      return ServerIntf.listarReservas(userId);
		}
		catch(Exception e) {
			System.out.println("Exception: " + e);
			return new ArrayList<Booking>();
		}
	}
  
  
}