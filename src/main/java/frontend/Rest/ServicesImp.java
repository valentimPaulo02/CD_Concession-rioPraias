package frontend.Rest;

import frontend.objects.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.ArrayList;
import java.util.List;

@Consumes("application/json")
@Produces("application/json")


public class ServicesImp implements Services {
	
<<<<<<< HEAD
	
	
	
	
	@POST
	@Path("/CANCELAR_SOMBRINHA")
	public Message CancelShadow(BeachService shadow) {
		
		
		
		
		
		return new Message("Succes", "CANCELAR_SOMBRINHA");
	}
=======
>>>>>>> e4e0323eeed050f1105652196e1918bd7326ddc2
	
	
	
	@GET
<<<<<<< HEAD
	@Path("/LISTAR_SOMBRINHAS")
	public ReturnBeachService GetBeachServices()
	{
		
=======
	@Path("/GetBeachServices")
	public ReturnBeachService GetBeachServices()
	{
		
		System.out.println("CHEGOU AO GETBEACHSERVICES");
>>>>>>> e4e0323eeed050f1105652196e1918bd7326ddc2
	
		List<BeachService> BeachServices = new ArrayList<BeachService>();
		
		BeachServices.add(new BeachService("A1", 'A', 4));
		BeachServices.add(new BeachService("B1", 'B', 1));
		BeachServices.add(new BeachService("C3", 'C', 10));
		
		
		ReturnBeachService result = new ReturnBeachService("OK", BeachServices);
		
<<<<<<< HEAD
		for(BeachService service: result.getBeachServices()) {
			System.out.println(service.getBeachId());
		}
		
	//	System.out.println("CHEGOU AO GETBEACHSERVICES");
=======
		
>>>>>>> e4e0323eeed050f1105652196e1918bd7326ddc2
		return result;
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
	@Path("/RESERVAR_SOMBRINHA")
<<<<<<< HEAD
	public Message ReserveShadow(ReserveShadowContent content) {

		Message result = new Message();
		
		if(content == null) {
			result.setContent("content_null");
			result.setOperation("ERROR");

		}	
		
		result.setContent(content.getBeach()  + ":Sucess");
		result.setOperation("OK");
=======
	public Message ReserveShadow(Message message) {

		Message result = new Message();
		
		if(!isElementPresent(Operation.class, message.getOperation().toString())) {
			message.setContent("unknown Opearation -> " + message.getOperation());
			message.setOperation("ERROR ---> VALID OPERATIONS: "
					+ "	RESERVAR_SOMBRINHA,"
					+ "	CANCELAR_SOMBRINHA,"
					+ "	LISTAR_SOMBRINHAS,"
					+ "	REGISTAR_UTILIZADOR");
		
			
		//error message returned has all the avauilable operations and returns the not available operation to the consumer	
			return message;
		}
		
		//goto client rmi and send
		
			
>>>>>>> e4e0323eeed050f1105652196e1918bd7326ddc2
		return result;
	}
	
	
	
	
	
	
<<<<<<< HEAD
	
	
	
	
	
	
	
	
=======
>>>>>>> e4e0323eeed050f1105652196e1918bd7326ddc2
	@POST
	@Path("/SendData")
	public Message SendData(Message message)
	{
		
		Message result = new Message();
		
		//System.out.println("Chegou aqui!!!!!!!");
	
		//if the operation that is recived isnt available returns error message
		if(!isElementPresent(Operation.class, message.getOperation().toString())) {
			result.setContent("unknown Opearation -> " + message.getOperation());
			result.setOperation("ERROR ---> VALID OPERATIONS: "
					+ "	RESERVAR_SOMBRINHA,"
					+ "	CANCELAR_SOMBRINHA,"
					+ "	LISTAR_SOMBRINHAS,"
					+ "	REGISTAR_UTILIZADOR");
<<<<<<< HEAD
			
			
			
			result.setContent("OK");
		
		
			
		//error message returned has all the avauilable operations and returns the not available operation to the consumer	
			return message;
=======
		
			
		//error message returned has all the avauilable operations and returns the not available operation to the consumer	
			return result;
>>>>>>> e4e0323eeed050f1105652196e1918bd7326ddc2

		}
			
		
		
		System.out.println();
		if(message.getOperation() == "RESERVAR_SOMBRINHA") {
			System.out.print("entrou aqui");
			result.setOperation("OK");
			result.setContent("operation succeded");
		
		}


<<<<<<< HEAD
		return message;
=======
		return result;
>>>>>>> e4e0323eeed050f1105652196e1918bd7326ddc2
		
	
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
