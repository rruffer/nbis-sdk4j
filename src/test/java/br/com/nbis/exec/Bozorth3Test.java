package br.com.nbis.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.nbis.api.Nbis;
import br.com.nbis.utiltest.UtilLoader;

/**
 * @link https://blog.travis-ci.com/2018-10-11-windows-early-release
 * @author rodolfo.mindtek
 *
 */
class Bozorth3Test {
	
	static File image = null;
	static String nameFile = "anelar-esq.bmp";
	
	@BeforeAll
	static void startAll() {
		image =  UtilLoader.getFileTest(nameFile);
	}

	@Test
	void bozorth3() {

		try {
			File wsq = Nbis.wsq().encoder(image).getFile();
			File xyt = Nbis.mindtct(wsq).getFile();
			int bozorth3 = Nbis.bozorth3(xyt, xyt);
			assertEquals(1034, bozorth3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	
	@AfterAll
	static void endAll() {
		image.delete();
	}

}
