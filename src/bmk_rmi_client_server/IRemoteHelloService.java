package bmk_rmi_client_server;

import java.rmi.*;

/**
 *
 * @author meirb
 */
public interface IRemoteHelloService extends Remote {

    String BINDING_NAME = "sample/HelloService";
    int PORT = 1100;

    Object sayHello(RemoteHello data) throws RemoteException;

    void stopServer() throws RemoteException;
}
