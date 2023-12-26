package backend;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import objects.*;

public class Server {
  public static void main(String args[]) {
    try {
    	
      Registry registry = LocateRegistry.createRegistry(1099);
    	
      ServerImplementation serverImpl = new ServerImplementation();
      registry.rebind("ServerFunctions", serverImpl);
      System.out.println("running");

    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}