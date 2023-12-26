package frontend.Rest;


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
	
	
	
	
	
	@POST
	@Path("/CANCELAR_SOMBRINHA")
	public Message CancelShadow(BeachService shadow) {
		
		
		
		
		
		return new Message("Succes", "CANCELAR_SOMBRINHA");
	}
	
	
	
	@GET
	@Path("/LISTAR_SOMBRINHAS")
	public ReturnBeachService GetBeachServices()
	{
		
	
		List<BeachService> BeachServices = new ArrayList<BeachService>();
		
		BeachServices.add(new BeachService("A1", 'A', 4));
		BeachServices.add(new BeachService("B1", 'B', 1));
		BeachServices.add(new BeachService("C3", 'C', 10));
		
		
		ReturnBeachService result = new ReturnBeachService("OK", BeachServices);
		
		for(BeachService service: result.getBeachServices()) {
			System.out.println(service.getBeachId());
		}
		
	//	System.out.println("CHEGOU AO GETBEACHSERVICES");
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
	public Message ReserveShadow(ReserveShadowContent content) {

		Message result = new Message();
		
		if(content == null) {
			result.setContent("content_null");
			result.setOperation("ERROR");

		}	
		
		result.setContent(content.getBeach()  + ":Sucess");
		result.setOperation("OK");
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
			
			
			
			result.setContent("OK");
		
		
			
		//error message returned has all the avauilable operations and returns the not available operation to the consumer	
			return message;

		}
			
		
		
		System.out.println();
		if(message.getOperation() == "RESERVAR_SOMBRINHA") {
			System.out.print("entrou aqui");
			result.setOperation("OK");
			result.setContent("operation succeded");
		
		}


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
