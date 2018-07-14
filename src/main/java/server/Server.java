package server;

import server.customized_resources.ObserverableResource;
import org.eclipse.californium.core.CoapServer;

import java.util.concurrent.Executors;

public class Server {
    static public void main(String[] args) {
        CoapServer server = new CoapServer();

        ObserverableResource observerable = new ObserverableResource("obs");

        server.add(observerable);

        Executors.newSingleThreadExecutor().execute(server::start);
    }
}
