package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin  = {
                "pretty",
                "html:target/cucumber-html-report"},
        glue = {"com.cafetownsend.test.stepdefs"},
        tags = "@a",
        features = {"src/test/resources/feature"}
        )
public class TestRunner {

}