package frontend.Rest;
import objects.*;


import javax.jws.WebService;



@WebService(name = "Services", targetNamespace = "http://Rest.frontend/")
public interface Services {
	
	
	//LISTAR SOMBRINHAS
	ReturnBeachService GetBeachServices();
	//RESERVAR SOMBRINHA
	Message ReserveShadow(Booking content);

	//CANCELAR_SOMBRINHA
	Message CancelShadow(Service shadow);
	
	//Message SendData(Message message);
	
}
