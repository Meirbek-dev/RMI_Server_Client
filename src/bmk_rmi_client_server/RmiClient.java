package bmk_rmi_client_server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

/**
 *
 * @author meirb
 */
public class RmiClient {

    final static String HOST = "localhost";

    public static void main(String... args) throws RemoteException, NotBoundException, InterruptedException {
        Registry registry = LocateRegistry.getRegistry(HOST, IRemoteHelloService.PORT);
        IRemoteHelloService service = (IRemoteHelloService) registry.lookup(IRemoteHelloService.BINDING_NAME);

        System.out.println(service.sayHello(new RemoteHello("John", 23)).toString());
        System.out.println(service.sayHello(new RemoteHello("Jan", 18)));
        System.out.println(service.sayHello(new RemoteHello("Hans", 24)));
        System.out.println(service.sayHello(new RemoteHello("Bill", 31)));
        Thread.sleep(3000);

        service.stopServer();
    }
}
