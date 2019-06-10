package br.com.nbis;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses({Bozorth3Test.class})
@SelectPackages("br.com.nbis")
public class SuiteTest {

}
