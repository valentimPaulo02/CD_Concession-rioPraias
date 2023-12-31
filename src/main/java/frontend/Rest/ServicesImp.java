package frontend.Rest;

import objects.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.xml.security.utils.UnsyncByteArrayOutputStream;

import frontend.ClientRMI;

import java.util.ArrayList;
import java.util.List;

@Consumes("application/json")
@Produces("application/json")


public class ServicesImp implements Services {
	

	@POST
	@Path("/CANCELAR_SOMBRINHA")
	public String cancelarSombrinha(Booking booking) {
		
		ClientRMI client = new ClientRMI();
		
		int result = client.cancelarSombrinha(booking.getId());
		
		if(result == -1) {
			return "ERROR;";
		}
		
		return "Success";
	}

	
	
	
	@POST
    @Path("/LISTAR_SOMBRINHAS")
    public ArrayList<Service> listarSombrinhas(Booking booking){
		
        ClientRMI rmi = new ClientRMI();
        return rmi.listarSombrinhas(booking);
        
    }


	@POST
	@Path("/RESERVAR_SOMBRINHA")
	public String reservarSombrinha(Booking booking) {	
		
		ClientRMI rmi = new ClientRMI();
		return "" + rmi.reservarSombrinha(booking);
		
	}

	
	@POST
	@Path("/LISTAR_RESERVAS")
	public ArrayList<Booking> listarReservas(User user){
		
		ClientRMI rmi = new ClientRMI();
		//return rmi.listarReservas(user.getId());
		return rmi.listarReservas(user.getId());
		
	}
	
	
	
	
	
	
	
}
