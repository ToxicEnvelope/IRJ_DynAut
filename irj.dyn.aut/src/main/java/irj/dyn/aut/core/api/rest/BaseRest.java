package irj.dyn.aut.core.api.rest;


import irj.dyn.aut.activity.utils.EnvManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseRest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRest.class);

    protected static String BASE_URL = EnvManager.getInstance().getEnvironmentUrl();
    private static String REQUEST_PATTERN[] = new String[2];

    public BaseRest(String uri) { bindEntryUri(uri); }

    private void bindEntryUri(String uri) {
        logger.info("Getting `"+uri+"`");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Passed -> `"+uri+"`");
        REQUEST_PATTERN = uri.split("/");
        System.out.println("IP ADDRESS -> `"+REQUEST_PATTERN[0]+"`");
        System.out.println("API -> `"+REQUEST_PATTERN[1]+"`");

        BASE_URL = BASE_URL.concat("/"+REQUEST_PATTERN[0]).concat("/"+REQUEST_PATTERN[1]);
        if (!BASE_URL.contains(uri)) {
            BASE_URL = BASE_URL.replace(BASE_URL, BASE_URL.concat(uri));
        }
        System.out.println("BASE URL -> `"+BASE_URL+"`");
        System.out.println("API REQUEST -> `"+BASE_URL+"/"+uri+"`");
    }
}
