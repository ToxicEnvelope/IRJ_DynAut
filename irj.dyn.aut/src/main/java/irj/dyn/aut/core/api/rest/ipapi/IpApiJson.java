package irj.dyn.aut.core.api.rest.ipapi;

import irj.dyn.aut.core.api.rest.BaseRest;

public class IpApiJson extends BaseRest {

    private static final String URI = "/json";

    public IpApiJson(String ipAddress) {
        super(ipAddress.concat(URI));
    }
}
