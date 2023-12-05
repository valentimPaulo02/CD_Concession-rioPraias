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
	@Path("/GetMessaegContent")
	public Message GetMessaegContent()
	{
		Message message = new Message();
		message.setMessageContent("o Paulinho e gay");
		System.out.print(message.getMessageContent());
		return message;
	}
	
	
}
