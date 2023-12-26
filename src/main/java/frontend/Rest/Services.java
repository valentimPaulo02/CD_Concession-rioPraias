package frontend.Rest;


import javax.jws.WebService;



@WebService(name = "Services", targetNamespace = "http://Rest.frontend/")
public interface Services {
	
	
	//LISTAR SOMBRINHAS
	ReturnBeachService GetBeachServices();
	//RESERVAR SOMBRINHA
	Message ReserveShadow(ReserveShadowContent content);
	
	
	
	
	
	
	//tester
	Message SendData(Message message);
	
}
