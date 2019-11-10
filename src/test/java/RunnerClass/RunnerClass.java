package RunnerClass;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\FeatureFiles",
        glue="StepDef",
        tags={"@last"})

public class RunnerClass {




}

