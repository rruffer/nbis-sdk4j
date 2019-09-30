package br.com.nbis.exec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.nbis.api.Nbis;
import br.com.nbis.utiltest.UtilLoader;

/**
 * @link https://blog.travis-ci.com/2018-10-11-windows-early-release
 * @author rodolfo.mindtek
 *
 */
@DisplayName("Test Bozorth 3")
class Bozorth3Test {
	
	static File image1 = null;
	static File image2 = null;
	static String img1 = "anelar-esq.bmp";
	static String img2 = "anelar-dir.bmp";
	
	@BeforeAll
	static void startAll() {
		image1 =  UtilLoader.getFileTest(img1);
		image2 =  UtilLoader.getFileTest(img2);
	}

	@Test
	@DisplayName("Valida digital igual")
	void validandoDigitaisIguais() {

		try {
			File wsq = Nbis.wsq().encoder(image1).getFile();
			File xyt = Nbis.mindtct(wsq).getFile();
			int result = Nbis.bozorth3(xyt, xyt);
			assertTrue(result >= 20);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	@DisplayName("Valida se digital \"a\" é igual a digital \"b\"")
	void validandoDigitaisNaoIguais() {
		
		try {
			File wsq1 = Nbis.wsq().encoder(image1).getFile();
			File wsq2 = Nbis.wsq().encoder(image2).getFile();
			File xyt1 = Nbis.mindtct(wsq1).getFile();
			File xyt2 = Nbis.mindtct(wsq2).getFile();
			int result = Nbis.bozorth3(xyt1, xyt2);
			assertFalse(result >= 20);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	@Disabled
	@DisplayName("Valida se digital já está na lista capturada")
	void notEqualsOneToAll() {
		
		try {
			File wsq1 = Nbis.wsq().encoder(image1).getFile();
			File wsq2 = Nbis.wsq().encoder(image2).getFile();
			File xyt1 = Nbis.mindtct(wsq1).getFile();
			File xyt2 = Nbis.mindtct(wsq2).getFile();
			int result = Nbis.bozorth3(xyt1, xyt2);
			assertFalse(result >= 20);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterAll
	static void endAll() {
		image1.delete();
	}

}
