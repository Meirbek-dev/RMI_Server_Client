package bmk_rmi_client_server;

import java.rmi.*;

// Интерфейс для описания возможностей сервера
public interface IRemoteSolution extends Remote {

    String SERVICE_NAME = "bmk/solution";
    int PORT = 1101;

    Object getData(Variables data) throws RemoteException;

    void stopServer() throws RemoteException;
}
