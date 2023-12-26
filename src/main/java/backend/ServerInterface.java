package backend;
import java.rmi.*;
import java.util.ArrayList;
import java.util.List;

import objects.*;

public interface ServerInterface extends Remote {
  ArrayList<Service> listarSombrinhas(String beach_id, String date, int start_time, int ending_time) throws RemoteException;
  ArrayList<Booking> listarReservas(int user_id) throws RemoteException;
  int cancelarSombrinha(int booking_id) throws RemoteException;
  int reservarSombrinha(int user_id, String beach_id, String service_id, String date, int start_time, int ending_time) throws RemoteException;
}
