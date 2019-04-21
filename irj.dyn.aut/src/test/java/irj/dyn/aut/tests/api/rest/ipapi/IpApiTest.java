package irj.dyn.aut.tests.api.rest.ipapi;

import irj.dyn.aut.core.api.rest.ipapi.IpApiJson;
import irj.dyn.aut.tests.BaseTest;
import org.testng.annotations.Test;

public class IpApiTest extends BaseTest {

    private static final String TD_IP_ADDR = "206.167.58.16";

    @Test
    public void test_that_json_return() {
        createTest(new Throwable().getStackTrace()[0].getMethodName());
        IpApiJson ipApiJson = new IpApiJson(TD_IP_ADDR);
        System.out.println("\n\n\nIP API JSON URL -> " + ipApiJson.getUrl());
    }

}
