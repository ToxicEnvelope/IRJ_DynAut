package irj.dyn.aut.core.api.soap;

import irj.dyn.aut.activity.utils.EnvManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseSoap {
    private static final Logger logger = LoggerFactory.getLogger(BaseSoap.class);

    private static final String DI_URL = EnvManager.getInstance().getDIEndpoint();
    private static final String OPEN_XML_ENVELOPE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vis="+DI_URL+">\n";
    private static final String XML_HEADER = "<soapenv:Header/>\n";
    private static final String OPEN_XML_BODY = "<soapenv:Body>\n";
    private static final String CLOSE_XML_BODY = "</soapenv:Body>\n";
    private static final String CLOSE_XML_ENVELOPE = "</soapenv:Envelope>\n";


    public BaseSoap(String uri) {
        bindEntryURI(uri);
    }

    protected String getDataIntegrationURL() {
        return DI_URL;
    }

    /**
     * This method builds a valid Soap structure format
     * @param stringXmlPayload - String represents the payload
     * @return - a formatted String in a constellation of the relevant XML Soap Request
     * @author Yahav N. Hoffman
     */
    protected String buildSoapPayload(String stringXmlPayload) {
        logger.info("Getting `"+stringXmlPayload+"`");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Getting `"+stringXmlPayload+"`");
        StringBuilder xml = new StringBuilder(
                OPEN_XML_ENVELOPE +
                    XML_HEADER +
                    OPEN_XML_BODY +
                        stringXmlPayload +
                    CLOSE_XML_BODY +
                CLOSE_XML_ENVELOPE);

        return xml.toString();
    }

    /**
     * @param uri - String that represent the URI of the WS
     * @author Yahav N. Hoffman
     */
    private void bindEntryURI(String uri) {
        logger.info("Getting `"+uri+"`");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Getting `"+uri+"`");
        if (OPEN_XML_ENVELOPE.contains(DI_URL)) {
            OPEN_XML_ENVELOPE.replace(DI_URL, DI_URL.concat(uri));
        }
        System.out.println("DI ENDPOINT -> `"+uri+"`");
    }
}
