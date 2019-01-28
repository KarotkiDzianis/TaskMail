package com.epam.linkedin.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"pretty"},
        glue = {"com.epam.linkedin"},
        features = "src/test/resources/features"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
