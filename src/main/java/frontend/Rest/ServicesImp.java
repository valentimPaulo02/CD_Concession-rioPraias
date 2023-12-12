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
		message.setContent("o Paulinho e gay");
		System.out.print(message.getContent());
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
	public Message SendData(Message message)
	{
		
		System.out.println("Chegou aqui!!!!!!!");
	
		
		
		
		if(isElementPresent(Operation.class, message.getOperation().toString())) {
			
			System.out.println("content da mensagem |content|	->   " + message.getContent());
			System.out.println("content da mensagem |operation|	->   " + message.getOperation());
			message.setOperation("ok");
		}
		
		
		message.setContent("unknown Opearation -> " + message.getOperation());
		message.setOperation("ERROR");
		return message;
	}
	
	
	
    // Method to check if an element is present in the enum
    private static <T extends Enum<T>> boolean isElementPresent(Class<T> enumClass, String targetElement) {
        try {
            // Attempt to retrieve the enum constant with the specified name
            Enum.valueOf(enumClass, targetElement);
            return true;
        } catch (IllegalArgumentException e) {
            // The specified name does not match any enum constant
            return false;
        }
    }
	
	
	
	
	
	
	
	
	
	
	
}
