package irj.dyn.aut.tests;

import irj.dyn.aut.tests.utils.GenerateExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest extends GenerateExtentReport
{
    public void createTest(String testMethodName) {
        logConsole("\nFrom "+ new Throwable().getStackTrace()[0].getClassName());
        logConsole("Calling "+ new Throwable().getStackTrace()[0].getMethodName());
        test = report.createTest(testMethodName);
    }

    @AfterMethod
    @Override
    public void getResult(ITestResult result) {
        super.getResult(result);
    }
}
