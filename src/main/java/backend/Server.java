package backend;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
  public static void main(String args[]) {
    try {
    	
      Registry registry = LocateRegistry.createRegistry(1099);
    	
      System.out.println("started");
      ServerImplementation addServerImpl = new ServerImplementation();
      Naming.rebind("AddServer", addServerImpl);
      System.out.println("working");

    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}