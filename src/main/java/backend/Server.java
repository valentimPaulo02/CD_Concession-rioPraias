package backend;
import java.net.*;
import java.rmi.*;

public class Server {
  public static void main(String args[]) {
    try {
      ServerImplementation addServerImpl = new ServerImplementation();
      Naming.rebind("AddServer", addServerImpl);

      
    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}