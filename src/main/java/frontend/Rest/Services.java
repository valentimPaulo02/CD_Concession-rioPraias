package frontend.Rest;
import objects.*;


import javax.jws.WebService;



@WebService(name = "Services", targetNamespace = "http://Rest.frontend/")
public interface Services {
	
	
	//LISTAR_SOMBRINHAS
	ReturnBeachService GetBeachServices();
	//RESERVAR_SOMBRINHA
	Message ReserveShadow(Booking content);
	//CANCELAR_SOMBRINHA
	Message CancelShadow(Service shadow);
	//LISTAR_RESERVAS
	
	//Message SendData(Message message);
	
}
