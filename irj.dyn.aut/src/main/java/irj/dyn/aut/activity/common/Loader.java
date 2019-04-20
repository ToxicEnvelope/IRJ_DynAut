package irj.dyn.aut.activity.common;

import irj.dyn.aut.activity.utils.EnvManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Loader {

    private static final Logger logger = LoggerFactory.getLogger(Loader.class);

    private static final String XML_SUITE_DIR = "xmls/";
    private static final String ENV_CONF_DIR = "conf/";

    private static final List<String> suiteFiles = new ArrayList<>();
    private static final Properties props = new Properties();
    private static final TestNG runner = new TestNG();
    private static final TestListenerAdapter tla = new TestListenerAdapter();

    /**
     * @param confFile - path of environment configuration file
     * @author Yahav N. Hoffman
     */
    public static void getFileProperties(String confFile)
    {
        logger.info("Getting `"+confFile+"` Properties...");
        logConsole("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        logConsole("Getting `"+confFile+"` Properties...");
        try {
            logConsole("Parsing Env Config File: `" + confFile+ "`...");
            InputStream stream = new FileInputStream(ENV_CONF_DIR + confFile);
            props.load(stream);
            EnvManager.getInstance().setProperties(props);
        }
        catch (Exception e) {
            logger.error("[Error] "+Thread.currentThread().getStackTrace()[0].getMethodName());
            logConsole("[Error] "+Thread.currentThread().getStackTrace()[0].getMethodName());
            e.printStackTrace();
        }
    }

    /**
     * @param xmlFile - path of string
     * @author Yahav N. Hoffman
     */
    public static void runXmlWithTestNG (String xmlFile)
    {
        logger.info("Running `"+xmlFile+"` Using TestNG...");
        logConsole("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        logConsole("Running `"+xmlFile+"` Using TestNG...");
        try {
            runner.addListener(tla);
            suiteFiles.add(XML_SUITE_DIR + xmlFile);
            runner.setTestSuites(suiteFiles);
            runner.run();
        }
        catch (Exception e) {
            logger.error("[Error] "+Thread.currentThread().getStackTrace()[0].getMethodName());
            logConsole("[Error] "+Thread.currentThread().getStackTrace()[0].getMethodName());
            e.printStackTrace();
        }
    }

    public static void logConsole(Object obj) {
        System.out.println(obj);
    }
}
