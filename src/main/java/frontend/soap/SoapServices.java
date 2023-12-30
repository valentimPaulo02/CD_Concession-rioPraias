package frontend.soap;
import frontend.objects.*;


import javax.jws.WebService;



@WebService(name = "Services", targetNamespace = "http://soap.frontend/")
public interface SoapServices {
	
	
	//LISTAR SOMBRINHAS
	ReturnBeachService GetBeachServices();
	//RESERVAR SOMBRINHA
	Message ReserveShadow(Message message);
	
	Message SendData(Message message);
	
	
}