package br.com.nbis;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("br.com.nbis")
@SuiteDisplayName("Testes SDK Nbis 5.0.0")
public class SuiteTest {

}
