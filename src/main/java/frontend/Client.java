package frontend;
import backend.*;
import java.rmi.*;

public class Client {
  public static void main(String args[]) {
    try {
      String addServerURL = "rmi://" + "localhost" + "/AddServer";
      ServerInterface addServerIntf = (ServerInterface)Naming.lookup(addServerURL);
      System.out.println("The first number is: " + 1);
      double d1 = 1;
      System.out.println("The second number is: " + 2);

      double d2 = 2;
      System.out.println("The sum is: " + addServerIntf.add(d1, d2));
    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}
