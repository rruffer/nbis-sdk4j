package br.com.nbis;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

//@RunWith(JUnitPlatform.class)
@Suite
@SelectPackages("br.com.nbis.exec")
@SuiteDisplayName("Testes SDK Nbis 5.0.0")
public class SuiteTest {

}
