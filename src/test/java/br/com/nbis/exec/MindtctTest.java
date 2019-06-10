package br.com.nbis.exec;

import static org.junit.Assert.assertTrue;

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
class MindtctTest {
	
	static File image = null;
	static String nameFile = "anelar-esq.bmp";
	
	@BeforeAll
	static void starttAll() {
		image =  UtilLoader.getFileTest(nameFile);
	}


	@Test
	void mindtct() {

		try {
			File wsq = Nbis.wsq().encoder(image).getFile();
			assertTrue(Nbis.mindtct(wsq).getFile().exists());
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
