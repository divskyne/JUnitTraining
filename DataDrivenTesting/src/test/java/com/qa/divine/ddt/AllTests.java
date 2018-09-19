package com.qa.divine.ddt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DDTReadOnly.class, OpenReport.class })
public class AllTests {

}
