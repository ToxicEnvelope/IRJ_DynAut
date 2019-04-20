package irj.dyn.aut.activity.common;


import irj.dyn.aut.activity.utils.IArgsAlert;
import irj.dyn.aut.activity.utils.IHelpMenu;
import irj.dyn.aut.activity.utils.IJarUtil;

public class ActionManager extends Loader implements IHelpMenu, IArgsAlert, IJarUtil
{
    public static void parseArgsExecute(String arg1, String arg2) {
        String xmlSuite;
        String envProps;
        if (arg1.toLowerCase().endsWith(SUFFIX)) {
            xmlSuite = arg1;
            envProps = arg2;
        }
        else {
            xmlSuite = arg2;
            envProps = arg1;
        }
        logConsole(XML_FILE_INDICATION + xmlSuite + ENV_FILE_INDICATION + envProps);
    }

    public static void execIllegalArgsInCmdError() {
        logConsole(ILLEGAL_ARGS_IN_CMD_ERROR + HELP_ALERT);
        kill();
    }

    public static void execArgsNotFoundInCmdError() {
        logConsole(ARGS_NOT_FOUND_IN_CMD_ERROR + HELP_ALERT);
        kill();
    }
    
    public static void displayHelpMenu() {
        logConsole(MENU_CLI_GUI_INTERFACE);
    }

    public static void displayVersion() {
        logConsole(VERSION + "\n" + RELEASE_DATE);
    }

    private static void kill() {
        logConsole(EXITING_STR);
        System.exit(1);
    }
}
