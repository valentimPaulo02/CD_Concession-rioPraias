package frontend.Rest;
import objects.*;


import javax.jws.WebService;

import java.util.ArrayList;

@WebService(name = "Services", targetNamespace = "http://Rest.frontend/")
public interface Services {
	
	
	//LISTAR_SOMBRINHAS
	ArrayList<Service> listarSombrinhas(Booking booking);
	//RESERVAR_SOMBRINHA
	String reservarSombrinha(Booking booking);
	//CANCELAR_SOMBRINHA
	String cancelarSombrinha(Booking booking);
	
	//LISTAR RESERVAS
	ArrayList<Booking> listarReservas(User user);
	
	
	
	//Message SendData(Message message);
	
}
