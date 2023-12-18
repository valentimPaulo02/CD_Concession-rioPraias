package frontend.Rest;
import frontend.objects.*;

import javax.jws.WebService;



@WebService(name = "Services", targetNamespace = "http://Rest.frontend/")
public interface Services {
	
	
	//LISTAR SOMBRINHAS
	ReturnBeachService GetBeachServices();
	//RESERVAR SOMBRINHA
	Message ReserveShadow(Message message);
	
	
	
	
	
	
	//tester
	Message SendData(Message message);
	
}
