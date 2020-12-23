package cucumberOptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        tags = "@SmokeTest",
        glue = "stepDefinitions"
//        monochrome = true
//        plugin = {"pretty",
//                "html:target/Reports/cucumberReport",
//                "json:target/Reports/cucumberReport.json",
//                "junit:target/Reports/cukes.xml"}
                )

public class TestRunner {
}
