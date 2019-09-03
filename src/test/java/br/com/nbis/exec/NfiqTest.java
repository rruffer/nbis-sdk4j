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
class NfiqTest {
	
	static File image = null;
	static String nameFile = "anelar-esq.bmp";
	
	@BeforeAll
	static void startAll() {
		image =  UtilLoader.getFileTest(nameFile);
	}

	@Test
	void nfiqFile() {

		try {
		File fileWsq = Nbis.wsq().encoder(image).getFile();
		int nfiq = Nbis.nfiq(fileWsq);
		//Nbis.close();
		
		assertEquals(40, nfiq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	@Test
	void nfiqString() {
		
		try {
			File fileWsq = Nbis.wsq().encoder(image).getFile();
			int nfiq = Nbis.nfiq(fileWsq);
			//Nbis.close();
			
			assertEquals(40, nfiq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@AfterAll
	static void endDownAll() {
		image.delete();
	}

}
