package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(	monochrome = true,
					dryRun = false,
					features = { "resources/features" },
					glue = { "stepsDefinition" },
					plugin = { 
								"html:target/cucumber-reports",
								"json:target/cucumber.json",
								"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/report.html"
							},
					tags = {"@CT01"}
				)

public class RunnerTest {

	@AfterClass
	public static void escreveExtentReport() throws Exception {
		Reporter.loadXMLConfig(FileReaderManager.getInstance().getConfigReader().getReportConfigPath());
	}
	
}

