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
    //private static LinkedHashMap config;

    /**
     * Constructor
     *
     * @throws IOException exception
     */
    protected Config() throws IOException {
        //config = getConfigData();
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

}