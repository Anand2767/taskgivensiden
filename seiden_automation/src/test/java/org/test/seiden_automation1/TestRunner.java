package org.test.seiden_automation1;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",dryRun=false, glue="org.stepdefinition", tags="@mk")
public class TestRunner{

}

