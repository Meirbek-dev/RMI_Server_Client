package bmk_rmi_client_server;

import java.util.Timer;
import java.util.TimerTask;
import bmk_rmi_client_server.RmiClient;
import bmk_rmi_client_server.RmiServer;

/**
 *
 * @author meirb
 */
public class BMK_RMI_CLIENT_SERVER {

    public static void main(String[] args) {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    RmiServer.main();
                } catch (Exception ex) {
                    System.err.println("RmiServer error!");
                }
            }
        }, 0);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    RmiClient.main();
                } catch (Exception ex) {
                    System.err.println("RmiClient error!");
                }
            }
        }, 1000);

    }
}
