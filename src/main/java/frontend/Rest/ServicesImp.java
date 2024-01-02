package frontend.Rest;

import objects.*;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.xml.security.utils.UnsyncByteArrayOutputStream;

import backend.Database;
import frontend.ClientRMI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebService(targetNamespace = "http://Rest.frontend/", endpointInterface = "frontend.Rest.Services", portName = "ServicesImpPort", serviceName = "ServicesImpService")
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
		return "A sua reserva foi cancelada com sucesso.";
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
		return rmi.listarReservas(user.getId());
	}
	
	
	@POST
	@Path("/REGISTAR_UTILIZADOR")
	public String registarUtilizador(User user){
	
		Database db = new Database();
		boolean valid = true;
		  
		try {
			db.connect();
			  
			String query1 = "SELECT * FROM User WHERE username=?";
			Map<Integer, Object> parameters1 = Map.of(1, user.getUsername());
			  
			List<Map<String, Object>> users = db.executeQueryGetData(query1, parameters1);
			// GET ALL USERNAMES FROM USER -> user.getUsername()
			  
			if(users.size()>0) {
				valid = false;
			}else {
				String query2 = "INSERT INTO User (username, password) VALUES (?, ?)";
				Map<Integer, Object> parameters2 = Map.of(1, user.getUsername(), 2, user.getPassword());
				  
				int dummy = db.executeQueryUpdateData(query2, parameters2);
				// INSERT USER INTO DB
			}
			  
			  
		}catch (SQLException e) {
			 e.printStackTrace();
		}finally {
			 try {
				 db.disconnect();
			 }catch (SQLException e){
				 e.printStackTrace();
			 }
		}
		return ""+valid;
	}
	
	
	@POST
	@Path("/LOGIN")
	public String login(User user){
		
		Database db = new Database();
		int returnId = 0;
		  
		try {
			db.connect();
			  
			String query1 = "SELECT * FROM User WHERE username=?";
			Map<Integer, Object> parameters1 = Map.of(1, user.getUsername());
			  
			List<Map<String, Object>> users = db.executeQueryGetData(query1, parameters1);
			// GET ALL USERNAMES FROM USER -> user.getUsername()
			  
			if(users.size()>0) {
				for (int x = 0; x < users.size(); x++) {
				    Map<String, Object> dbUser = users.get(x);
				    String password = (String) dbUser.get("password");
				    String username = (String) dbUser.get("username");
				    int userId = (int) dbUser.get("user_id");
				    
				    if(!user.getUsername().equals(username)) {
				    	return "-1";
				    }
				    if(!user.getPassword().equals(password)) {
				    	return "-2";
				    }
				    returnId = userId;
				}
			}
			  
		}catch (SQLException e) {
			 e.printStackTrace();
		}finally {
			 try {
				 db.disconnect();
			 }catch (SQLException e){
				 e.printStackTrace();
			 }
		}
		return ""+returnId;
	}	
}
