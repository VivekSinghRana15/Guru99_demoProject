package com.guru99demo.runnerFile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/FeatureFiles",
        glue = "com/guru99demo/stepDefinitions",
        dryRun = false,
        plugin = {"pretty","html:src/test/Reports/CucumberReport.html"},
        tags = "@Vivek"
)


public class TestRunner {
}
