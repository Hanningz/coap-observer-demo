package client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;

import java.util.concurrent.Executors;

public class Client {
    static public void main(String[] args) {
        CoapClient client = new CoapClient("coap://localhost:5683/obs");
        Executors.newSingleThreadExecutor().execute(() ->
                client.observe(new CoapHandler() {
                    @Override
                    public void onLoad(CoapResponse coapResponse) {
                        System.out.println(Utils.prettyPrint(coapResponse));
                    }

                    @Override
                    public void onError() {

                    }
                })
        );
    }
}
