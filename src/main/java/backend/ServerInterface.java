package backend;
import java.rmi.*;

public interface ServerInterface extends Remote {
  double add(double d1, double d2) throws RemoteException;
}
