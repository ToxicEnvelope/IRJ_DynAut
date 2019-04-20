package irj.dyn.aut.activity.enums;

public enum Command
{
    HELP("help"),
    VERSION("version"),
    SUITE("suite"),
    ENV("env");

    private String value;
    Command(String value) { this.value = value; }

    public String toString() {
        return value;
    }
}
