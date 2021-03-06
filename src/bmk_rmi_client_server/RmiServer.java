package bmk_rmi_client_server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author meirb
 */
public class RmiServer implements IRemoteHelloService {

    private static AtomicBoolean stopServer = new AtomicBoolean(false);

    @Override
    public Object sayHello(RemoteHello data) throws RemoteException {
        String txt = "Hello, " + data + "!";
        try {
            System.out.println(txt + " from " + UnicastRemoteObject.getClientHost());
        } catch (ServerNotActiveException e) {
            System.out.println(e.getMessage());
        }
        return txt;
    }

    @Override
    public void stopServer() throws RemoteException {
        System.out.println("Shutting down...");
        stopServer.set(true);
    }

    public static void main(String... args) throws RemoteException, AlreadyBoundException {
        final Registry registry = LocateRegistry.createRegistry(IRemoteHelloService.PORT);

        final IRemoteHelloService service = new RmiServer();
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        registry.bind(IRemoteHelloService.BINDING_NAME, stub);

        while (!stopServer.get()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }

        System.out.println("Server stopped");
        System.exit(0);

    }
}
