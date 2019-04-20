package irj.dyn.aut.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Config {

    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    private static final String TEST_OUTPUT_DIR = "/test-output";
    private static Config instance = null;
    private static LinkedHashMap config;

    /**
     * Constructor
     *
     * @throws IOException exception
     */
    protected Config() throws IOException {
        config = getConfigData();
    }

    /**
     * Explicitly instantiate singleton Config object if one does not exist
     *
     * @return Config object
     * @throws IOException exception
     */
    public static Config getInstance()
    {
        if (instance == null) {
            try {
                instance = new Config();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * return the ROOT Project Dir
     * @return
     * @author Yahav N. Hoffman
     */
    public static String getProjectRootDir() {
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        return System.getProperty("user.dir").replace("\\","/");
    }

    /**
     * return the ROOT Project Dir
     * @return
     * @author Yahav N. Hoffman
     */
    public static String getTestOutputDir() {
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        return getProjectRootDir().concat(TEST_OUTPUT_DIR);
    }

    /**
     * Returns LinkedHashMap yaml-parsed data from config file
     *
     * @return LinkedHashMap
     * @throws NullPointerException exception
     */
    public static LinkedHashMap getConfigData() throws NullPointerException
    {
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        final String defaultFileName = "/config.yaml";
        final String localFileName = "/local-config.yaml";

        Yaml yaml = new Yaml();
        LinkedHashMap configData;

        logger.info("Locating local configuration file, \"" + localFileName + "\"...");
        try {

            InputStream localFile = Config.class.getResourceAsStream(localFileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(localFile));

            logger.info("Local configuration file, \"" + localFileName + "\" found. Parsing yaml file...");
            configData = (LinkedHashMap) yaml.load(reader);

        } catch (NullPointerException e) {

            logger.info("Could not locate/read local configuration file \"" + localFileName
                    + "\". Locating default configuration file, \"" + defaultFileName + "\"...");

            try {

                InputStream defaultFile = Config.class.getResourceAsStream(defaultFileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(defaultFile));

                logger.info("Default configuration file, \"" + defaultFileName + "\" found. Parsing yaml file...");
                configData = (LinkedHashMap) yaml.load(reader);

            } catch (NullPointerException ex) {

                logger.info("Could not locate/read default configuration file \"" + defaultFileName + "\"...");
                throw ex;

            }

        }

        return configData;

    }

    /**
     * return the current running OS
     * @return - String
     * @author Yahav N. Hoffman
     */
    public static String getWorkingOS() {
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        return System.getProperty("os.name");
    }

    public static LinkedHashMap getConfigDataForJar() throws NullPointerException
    {
        System.out.println("\nCalling "+ new Throwable().getStackTrace()[0].getMethodName());
        final String localFileName = "/conf/envProperties.yaml";

        Yaml yaml = new Yaml();
        LinkedHashMap configData;

        logger.info("Locating local configuration file, \"" + localFileName + "\"...");

        InputStream localFile = Config.class.getResourceAsStream(localFileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(localFile));

        logger.info("Local configuration file, \"" + localFileName + "\" found. Parsing yaml file...");
        configData = (LinkedHashMap) yaml.load(reader);
        /** TODO - solve NullPointerException**/
        /*try {
            InputStream localFile = Config.class.getResourceAsStream(localFileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(localFile));
            logger.info("Local configuration file, \"" + localFileName + "\" found. Parsing yaml file...");
            configData = (LinkedHashMap) yaml.load(reader);
        } catch (NullPointerException e) {
            logger.info("Could not locate/read local configuration file \"" + localFileName + "\"...");
            throw e;
        }*/

        return configData;
    }

}