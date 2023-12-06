package frontend.Rest;

import javax.jws.WebService;

@WebService(name = "Services", targetNamespace = "http://Rest.frontend/")
public interface Services {
	
	Message GetSombrinhas();
	String SendData(Message message);
	
}
