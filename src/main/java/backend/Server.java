package backend;
import java.net.*;
import java.rmi.*;

public class Server {
  public static void main(String args[]) {
    try {
    	
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