package backend;
import java.rmi.*;
import java.io.Serializable;

public interface ServerInterface extends Serializable {
  double add(double d1, double d2) throws RemoteException;
}
