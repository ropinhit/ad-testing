package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
//        plugin  = {
//                "pretty",
//                "html:target/cucumber-html-report",
//                "json-pretty:target/cucumber-report.json",
//                "io.cucumber.pro.JsonReporter:smoke"
//        },
        glue = {"com.cafetownsend.test.stepdefs"},
        tags = "@a",
        features = {"src/test/resources/feature"}
        )
public class TestRunner {

}