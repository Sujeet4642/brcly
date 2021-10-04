package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:Features",
		glue="Stepdefs",
		tags="@SignUp",
		plugin= {"pretty",
				"html:target/html/htmlreport.html",
				"json:target/json/file.json",
		        },
		publish=true,
		dryRun=false
		)

public class TestRunner {
}
