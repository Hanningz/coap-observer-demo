package server.customized_resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ObserverableResource extends CoapResource {

    private String currentTimeString;

    static final private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ObserverableResource(String name) {
        super(name);

        setObservable(true);
        setObserveType(CoAP.Type.CON);

        Timer timer;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                resetCurrentTime();
                changed();
            }
        }, 0, 5000);
    }

    private void resetCurrentTime() {
        Date currentDate = new Date();
        currentTimeString = DATE_FORMAT.format(currentDate);
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.setMaxAge(5);
        exchange.respond(currentTimeString);
    }

}
