package frontend.Rest;
import frontend.objects.*;


import javax.jws.WebService;



@WebService(name = "Services", targetNamespace = "http://Rest.frontend/")
public interface Services {
	
	
	//LISTAR SOMBRINHAS
	ReturnBeachService GetBeachServices();
	//RESERVAR SOMBRINHA
<<<<<<< HEAD
	Message ReserveShadow(ReserveShadowContent content);
=======
	Message ReserveShadow(Message message);
>>>>>>> e4e0323eeed050f1105652196e1918bd7326ddc2
	
	
	
	
	
	
	//tester
	Message SendData(Message message);
	
}
