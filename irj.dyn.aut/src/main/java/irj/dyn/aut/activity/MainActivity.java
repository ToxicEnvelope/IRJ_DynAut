package irj.dyn.aut.activity;

import irj.dyn.aut.activity.common.ActionManager;
import irj.dyn.aut.activity.enums.Command;

public class MainActivity
{

    private static final String PREFIX = "-";

    public static void main(String[] args)
    {
        if (args.length != 0)
        {
            if (args.length == 1) {

                if (args[0].equals(PREFIX.concat(Command.HELP.toString()))) {
                    ActionManager.displayHelpMenu();
                }
                else if (args[0].equals(PREFIX.concat(Command.VERSION.toString()))) {
                    ActionManager.displayVersion();
                }
                else {
                    ActionManager.execIllegalArgsInCmdError();
                }
            }
            else {
                if (args[0].equals(PREFIX.concat(Command.SUITE.toString())) && args[2].equals(PREFIX.concat(Command.ENV.toString()))
                        || args[0].equals(PREFIX.concat(Command.ENV.toString())) && args[2].equals(PREFIX.concat(Command.SUITE.toString())))
                {
                    ActionManager.parseArgsExecute(args[1], args[3]);
                }
                else {
                    ActionManager.execIllegalArgsInCmdError();
                }
            }
        } else {
            ActionManager.execArgsNotFoundInCmdError();
        }
    }
}
