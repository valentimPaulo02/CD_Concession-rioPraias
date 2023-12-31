package frontend.soap;

import frontend.objects.*;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;


@WebService(targetNamespace = "http://soap.frontend/", endpointInterface = "frontend.soap.SoapServices", portName = "SoapServicesImpPort", serviceName = "SoapServicesImpService")
@Service

public class SoapServicesImp implements SoapServices{

    public SoapServicesImp() {
    }

    @Override
	public String cancelarSombrinha(Booking booking) {
		
		SoapClient client = new SoapClient();
		
		int result = client.cancelarSombrinha(booking.getId());
		
		if(result == -1) {
			return "ERROR;";
		}
		
		return "Success";
	}


    @Override
    public ArrayList<Service> listarSombrinhas(Booking booking){
		
        SoapClient soap = new SoapClient();
        
        return soap.listarSombrinhas(booking);
        
    }

    @Override
	public int reservarSombrinha(Booking content) {	
		
    	
		SoapClient soap = new SoapClient();
		
		
		return soap.reservarSombrinha(content);
		
	}
    
    @Override
    public ArrayList<Booking> listarReservas(User user){
		SoapClient soap = new SoapClient();
		//return rmi.listarReservas(user.getId());
		return soap.listarReservas(1);
		
	}
}