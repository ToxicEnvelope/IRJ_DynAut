package irj.dyn.aut.activity.utils;

public interface IHelpMenu {

    String MENU_CLI_GUI_INTERFACE = new StringBuffer(
            "\nExecuting Help Menu Option..." +
            "\n" +
            "\n[NOTE]" +
            "\n When specified an <option> a {value} must follow, otherwise JAR will not run!" +
            "\n This JAR Application expects an XML file as Input," +
            "\n Given parameters below.\n" +
            "\n[OPTIONS]\t\t\t[DESCRIPTION]" +
            "\n -help\t\t\t\t Display help menu." +
            "\n -version\t\t\t JAR Version and Release Date." +
            "\n -suite  {suite.xml}\t\t Executes a suite XML file: Sanity / Regression / Smoke / Etc.." +
            "\n -env {env.conf.txt}\t\t A set of environment parameters: URL / DB_CONN / DOCKER_PORT/ Etc..." +
            "\n\n[Example]" +
            "\n `java -jar {file.jar} -suite {suite.xml} -env {env-conf.properties}`").toString();
    String HELP_ALERT = "\nUse `-help` for more details!";
}
