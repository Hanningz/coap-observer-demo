package server;

import server.customized_resources.ObservableResource;
import org.eclipse.californium.core.CoapServer;

import java.util.concurrent.Executors;

public class Server {
    static public void main(String[] args) {
        CoapServer server = new CoapServer();

        // ObservableResource是CoapResource的一个子类
        ObservableResource observerable = new ObservableResource("obs");

        server.add(observerable);

        Executors.newSingleThreadExecutor().execute(server::start);
    }
}
