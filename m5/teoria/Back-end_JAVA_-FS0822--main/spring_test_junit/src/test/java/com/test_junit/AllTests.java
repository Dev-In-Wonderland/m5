package com.test_junit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ Test2.class, UserTest.class })
public class AllTests {

}
