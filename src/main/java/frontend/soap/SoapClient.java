package frontend.soap;
import backend.*;
import frontend.objects.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.net.URL;

public class SoapClient {
	
	public SoapClient() {
	}
	
	public int reservarSombrinha(Booking booking) {
		try {
    	
	      Registry registry = LocateRegistry.getRegistry("192.168.139.128");
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
	    	
		      Registry registry = LocateRegistry.getRegistry("192.168.139.128");
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
	    	
		      Registry registry = LocateRegistry.getRegistry("192.168.139.128");
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
	    	
		      Registry registry = LocateRegistry.getRegistry("192.168.139.128");
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