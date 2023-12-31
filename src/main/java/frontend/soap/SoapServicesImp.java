package frontend.soap;


import frontend.ClientRMI;

import objects.*;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;




@WebService(targetNamespace = "http://soap.frontend/", endpointInterface = "frontend.soap.SoapServices", portName = "SoapServicesImpPort", serviceName = "SoapServicesImpService")
public class SoapServicesImp implements SoapServices{

    public SoapServicesImp() {
    }

    @Override
	public String cancelarSombrinha(Booking booking) {
		
		ClientRMI client = new ClientRMI();
		
		int result = client.cancelarSombrinha(booking.getId());
		
		if(result == -1) {
			return "ERROR;";
		}
		
		return "Success";
	}


    @Override
    public ArrayList<objects.Service> listarSombrinhas(Booking booking){
		
        ClientRMI rmi = new ClientRMI();
        
        return rmi.listarSombrinhas(booking);
        
    }

    @Override
	public String reservarSombrinha(Booking booking) {	
		
    	
		ClientRMI rmi = new ClientRMI();
		
		
		return "" + rmi.reservarSombrinha(booking);
		
	}
    
    @Override
    public ArrayList<Booking> listarReservas(User user){
		ClientRMI rmi = new ClientRMI();
		//return rmi.listarReservas(user.getId());
		return rmi.listarReservas(user.getId());
		
	}
}