package Runner;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features"
        ,glue={"StepDefinitions"},
        plugin  ={
                "pretty",
                   "html:target/cucumber-default-report.html",
                "json: target/cucumber-json/report.json",
           }
        )
public class Runner extends AbstractTestNGCucumberTests {
    @DataProvider
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
}
}
