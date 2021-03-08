package bmk_rmi_client_server;

import java.rmi.registry.*;

// Клиент RMI
public class RmiClient {

    final static String HOST = "localhost"; // Адрес сервера

    public static void main(String... args) throws Exception {
        Registry server = LocateRegistry.getRegistry(HOST, IRemoteSolution.PORT);
        IRemoteSolution remoteService = (IRemoteSolution) server.lookup(IRemoteSolution.SERVICE_NAME);
        System.out.println(remoteService.getData(new Variables(1, 2, 3))); //a, b, x
        System.out.println(remoteService.getData(new Variables(6.5, -4, 7)));
        remoteService.stopServer();
    }
}
