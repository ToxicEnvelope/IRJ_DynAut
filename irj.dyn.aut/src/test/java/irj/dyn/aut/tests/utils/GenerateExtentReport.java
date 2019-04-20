package irj.dyn.aut.tests.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.RestAssured;
import irj.dyn.aut.activity.utils.EnvManager;
import irj.dyn.aut.core.Config;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class GenerateExtentReport extends RestAssured
{

    private static final String ENVIRONMENT = "Environment";
    private static final String JDBC_CONN = "JDBC Connection";
    private static final String DOCKER_STR = "Docker String";
    private static final String DOCKER_PORT = "Docker Port";
    private static final String OLTP_USER = "OLTP User";
    private static final String OLTP_PASS = "OLTP Pass";


    protected static ExtentReports report;
    private static ExtentHtmlReporter html;
    protected static ExtentTest test;

    @BeforeTest
    public void startReport()
    {
        logConsole("\nFrom "+ new Throwable().getStackTrace()[0].getClassName());
        logConsole("Calling "+ new Throwable().getStackTrace()[0].getMethodName());
        // initialize the HtmlReporter
        html = new ExtentHtmlReporter(Config.getTestOutputDir().concat("/ExtentReportFiles/TestsReport"+System.currentTimeMillis()+".html"));

        // Initialize ExtentReports and attach the HtmlReporter
        report = new ExtentReports();
        report.attachReporter(html);

        // To add system or environment info by using the setSystemInfo method.
        report.setSystemInfo(ENVIRONMENT, EnvManager.getInstance().getEnvironmentUrl());
        report.setSystemInfo(JDBC_CONN, EnvManager.getInstance().getJdbcConnection());
        report.setSystemInfo(DOCKER_STR, EnvManager.getInstance().getDockerStr());
        report.setSystemInfo(DOCKER_PORT, EnvManager.getInstance().getDockerPort());
        report.setSystemInfo(OLTP_USER, EnvManager.getInstance().getOltpUserSchema());
        report.setSystemInfo(OLTP_PASS, EnvManager.getInstance().getOltpPassSchema());

        //configuration items to change the look and feel
        //add content, manage tests etc
        html.config().setDocumentTitle("Extent Report Demo");
        html.config().setReportName("Test Report");
        html.config().setTheme(Theme.DARK);
        html.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @AfterMethod
    public void getResult(ITestResult result)
    {
        logConsole("\nFrom "+ new Throwable().getStackTrace()[0].getClassName());
        logConsole("Calling "+ new Throwable().getStackTrace()[0].getMethodName());
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void tearDown()
    {
        logConsole("\nFrom "+ new Throwable().getStackTrace()[0].getClassName());
        logConsole("Calling "+ new Throwable().getStackTrace()[0].getMethodName());
        //to write or update test information to reporter
        report.flush();
    }

    public void logConsole(String msg) { System.out.println(msg); }

}


