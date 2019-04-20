package irj.dyn.aut.core.api.rest;


import irj.dyn.aut.activity.utils.EnvManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseRest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRest.class);

    private static final String BASE_URL = EnvManager.getInstance().getEnvironmentUrl();
    private static String IP_INPUT = "";

    public BaseRest(String uri) { bindEntryUri(uri); }

    private void bindEntryUri(String uri) {
        logger.info("Getting `"+uri+"`");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Getting `"+uri+"`");
        IP_INPUT = String.format(String.valueOf(uri.split("/")));
        if (BASE_URL.contains(IP_INPUT)) {
            BASE_URL.replace(BASE_URL, BASE_URL.concat(uri));
        }
        System.out.println("BASE API -> `"+uri+"`");
    }
}
