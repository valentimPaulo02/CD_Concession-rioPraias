package frontend;
import backend.*;
import objects.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class ClientRMI {
	
	public ClientRMI() {
		
	}
	
  public int reservarSombrinha() {
    try {
    	
      Registry registry = LocateRegistry.getRegistry("192.168.139.128");
    	
      ServerInterface ServerIntf = (ServerInterface)registry.lookup("ServerFunctions");
   
      
      // TEST FOR reservarSombrinha
      /* vai retornar o numero de pessoas que se podem sentar ao ser reservada a sombrinha em questão
      */ 
      return ServerIntf.reservarSombrinha(1, "A", "A20", "2023-06-18", 9, 15);
      
    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
      return -1;
    }
  }
}