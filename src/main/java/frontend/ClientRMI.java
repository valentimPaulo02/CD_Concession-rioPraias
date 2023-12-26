package frontend;
import backend.*;
import objects.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class ClientRMI {
  public static void main(String args[]) {
    try {
    	
      Registry registry = LocateRegistry.getRegistry();
    	
      ServerInterface ServerIntf = (ServerInterface)registry.lookup("ServerFunctions");
   
      // TEST FOR ListarSombrinhas
      /* vai retornar uma lista com todas as sombrinhas disponiveis naquela praia, naquela data, naquele horário
      ArrayList<Service> services = ServerIntf.listarSombrinhas("A", "2023-06-17", 9, 10);
      System.out.println(services.size());
      for(int x=0; x<services.size();x++) {
    	  System.out.println(services.get(x).getId());
      }
      */
      
      
      // TEST FOR ListarReservas
      /* vai retornar uma lista com todas as reservas que um utilizador fez, função auxiliar
      ArrayList<Booking> bookings = ServerIntf.listarReservas(2);
      System.out.println(bookings.size());
      for(int x=0; x<bookings.size();x++) {
    	  System.out.println(bookings.get(x).getDate());
      }
      */
      
      
      // TEST FOR CancelarSombrinha
      /* retorna o numero de colunas afetadas (vai ser sempre 1)
      int rows = ServerIntf.cancelarSombrinha(5);
      System.out.println("Deleted with sucess and affected "+rows+" rows");   
      */
      
      
      // TEST FOR reservarSombrinha
      /* vai retornar o numero de pessoas que se podem sentar ao ser reservada a sombrinha em questão
      System.out.println(ServerIntf.reservarSombrinha(1, "A", "A20", "2023-06-18", 9, 15));
      */ 
      
    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}