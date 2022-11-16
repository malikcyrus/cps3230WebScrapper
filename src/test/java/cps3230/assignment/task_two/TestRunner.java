package cps3230.assignment.task_two;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"cps3230.assignment.task_two.stepDefinitions"}
)

public class TestRunner {
}
