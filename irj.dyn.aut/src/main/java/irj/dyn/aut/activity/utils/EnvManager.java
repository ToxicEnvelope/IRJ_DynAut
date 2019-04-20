package irj.dyn.aut.activity.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvManager
{
    private static final Logger logger = LoggerFactory.getLogger(EnvManager.class);

    private static final String URL = "url";
    private static final String JDBC_CONN = "ldapConn";
    private static final String DOCKER_STR = "dockerStr";
    private static final String DOCKER_PORT = "dockerPort";
    private static final String OLTP_USER = "oltpUser";
    private static final String OLTP_PASS = "oltpPass";
    private static final String AUTH_CREDS_WS = "authCredsWS";
    private static final String WS_ENDPOINT = "wsEndpoint";
    private static final String DI_ENDPOINT = "diEndpoint";


    private static Map<Object, Object> externalParameters = new HashMap<>();

    private static EnvManager instance = null;

    /**
     * Explicitly instantiate singleton EnvManager object if one does not exist
     * @return EnvManager object
     * @throws Exception exception
     */
    public static EnvManager getInstance()
    {
        if (instance == null) {
            try {
                instance = new EnvManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * takes properties Map
     * @param props Properties object
     * @author Yahav N. Hoffman
     */
    public void setProperties(Properties props)
    {
        logger.info("Handling Environment File Parameters...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Handling Environment File Parameters...");
        for (Map.Entry<Object, Object> entry : props.entrySet())
        {
            externalParameters.put(entry.getKey(), entry.getValue());
        }
    }

    public String getEnvironmentUrl() {
        logger.info("Getting Url...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Parsing `"+URL+"` From File -> '"+externalParameters.get(URL).toString()+"'...");
        return externalParameters.get(URL).toString();
    }
    public String getJdbcConnection() {
        logger.info("Getting LDAP Connection...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Parsing `"+JDBC_CONN+"` From File -> '"+externalParameters.get(JDBC_CONN).toString()+"'...");
        return externalParameters.get(JDBC_CONN).toString();
    }
    public String getDockerStr() {
        logger.info("Getting Docker String...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Parsing `"+DOCKER_STR+"` From File -> '"+externalParameters.get(DOCKER_STR).toString()+"'...");
        return externalParameters.get(DOCKER_STR).toString();
    }
    public String getDockerPort() {
        logger.info("Getting Docker Port...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Parsing `"+DOCKER_PORT+"` From File -> '"+externalParameters.get(DOCKER_PORT).toString()+"'...");
        return externalParameters.get(DOCKER_PORT).toString();
    }
    public String getOltpUserSchema() {
        logger.info("Getting OLTP Username...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Parsing `"+OLTP_USER+"` From File -> '"+externalParameters.get(OLTP_USER).toString()+"'...");
        return externalParameters.get(OLTP_USER).toString();
    }
    public String getOltpPassSchema() {
        logger.info("Getting OLTP Password...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Parsing `"+OLTP_PASS+"` From File -> '"+externalParameters.get(OLTP_PASS).toString()+"'...");
        return externalParameters.get(OLTP_PASS).toString();
    }

    public String getAuthCredsWS() {
        logger.info("Getting WS Auth Credetials...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Parsing `"+AUTH_CREDS_WS+"` From File -> '"+externalParameters.get(AUTH_CREDS_WS).toString()+"'...");
        return externalParameters.get(AUTH_CREDS_WS).toString();
    }

    public String getWSEndpoint() {
        logger.info("Getting WS Auth Credetials...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Parsing `"+WS_ENDPOINT+"` From File -> '"+externalParameters.get(WS_ENDPOINT).toString()+"'...");
        return externalParameters.get(WS_ENDPOINT).toString();
    }

    public String getDIEndpoint() {
        logger.info("Getting WS Auth Credetials...");
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("Parsing `"+DI_ENDPOINT+"` From File -> '"+externalParameters.get(DI_ENDPOINT).toString()+"'...");
        return externalParameters.get(DI_ENDPOINT).toString();
    }
}
