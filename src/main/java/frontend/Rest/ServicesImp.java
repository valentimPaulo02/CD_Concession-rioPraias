package frontend.Rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Consumes("application/json")
@Produces("application/json")


public class ServicesImp implements Services {

	@GET
	@Path("/GetSombrinhas")
	public Message GetSombrinhas()
	{
		Message message = new Message();
		message.setMessageContent("o Paulinho e gay");
		System.out.print(message.getMessageContent());
		return message;
	}
	
	
	
	
	/*
	 * 
	 * User-Agent: Fiddler
		Host: localhost:8080
		Content-Length: 61
		Conten-Type: application/json

	 * {"Message":{"content":"ok", "operacion":"ola"}}
	 * 
	 * 
	 * */
	
	@POST
	@Path("/SendData")
	public String SendData(Message message)
	{
		switch(message.getOperation()) 
		{
		case "ReservarSombrinha":
			return "{\"result\":\"ok\"}";
		case "Cancelarsombrinha":
			return "{\"result\":\"ok\"}";
		case "Listarsombrinhas":
			return "{\"result\":\"ok\"}";
		case "RegistarUtilizador":
			return "{\"result\":\"ok\"}";
		default:
			return "{\"result\":\"e\"}";
			
		}
		
	}
	
}
