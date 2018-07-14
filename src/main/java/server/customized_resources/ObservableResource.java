package server.customized_resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ObservableResource extends CoapResource {

    /**
     * 一个可观察（Observable）的资源类，每5秒向观察者推送一次当前时间
     */

    private String currentTimeString;
    static final private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ObservableResource(String name) {

        super(name);

        setObservable(true);    // 设定为可观察模式
        setObserveType(CoAP.Type.CON);  // 将观察的连接类型设为CON

        Timer timer;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                resetCurrentTime();
                changed();  // 更新推送
            }
        }, 0, 5000);    // 开启计时器，每5秒更新一次推送
    }

    private void resetCurrentTime() {
        Date currentDate = new Date();
        currentTimeString = DATE_FORMAT.format(currentDate);
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond(currentTimeString);
    }

}
