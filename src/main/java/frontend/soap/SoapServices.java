package frontend.soap;
import frontend.objects.*;


import javax.jws.WebService;

import java.util.ArrayList;

@WebService(name = "Services", targetNamespace = "http://soap.frontend/")
public interface SoapServices {
	
		//LISTAR SOMBRINHAS
		ArrayList<Service> listarSombrinhas(Booking booking);
		//RESERVAR SOMBRINHAS
		int reservarSombrinha(Booking content);
		//CANCELAR SOMBRINHA
		String cancelarSombrinha(Booking booking);
		//LISTAR RESERVAS
		ArrayList<Booking> listarReservas(User user);
		
		
	
	
}