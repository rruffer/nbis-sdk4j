package br.com.nbis.exec;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @link https://blog.travis-ci.com/2018-10-11-windows-early-release
 * @author rodolfo.mindtek
 *
 */
class NbisTest {

	@Test
	void encoderStringWSQ() {

		assertTrue(Nbis.wsq().encoder("101_1.tif").get().exists());

	}

	@Test
	@Disabled
	void encoderFileWSQ() {
		File file = new File("anelar-dir.bmp");
		
		Nbis.wsq().encoder(file);

		assertTrue(new File("anelar-dir.wsq").exists());

	}
	
	@Test
	@Disabled
	void encoderByteArrayWSQ() throws IOException {
		
		File file = new File("anelar-dir.bmp");
		byte[] readAllBytes = Files.readAllBytes(file.toPath());
		
		Nbis.wsq().encoder(readAllBytes);
		
		assertTrue(new File("anelar-dir.wsq").exists());
		
	}

	@Test
	@Disabled
	void decoderWSQ() {

		Nbis.wsq().encoder("anelar-dir.bmp");

		Nbis.wsq().decoder("anelar-dir.wsq");

		assertTrue(new File("anelar-dir.raw").exists());
	}

	@Test
	@Disabled
	void nfiq() {

		Nbis.wsq().encoder("anelar-dir.bmp");

		int nfiq = Nbis.nfiq("anelar-dir.wsq");

		assertEquals(100, nfiq);

	}

	@Test
	@Disabled
	void mindtct() {

		Nbis.wsq().encoder("anelar-dir.bmp");
		Nbis.mindtct("anelar-dir.wsq");

		assertTrue(new File("anelar-dir.xyt").exists());

	}

	@Test
	@Disabled
	void bozorth3() {

		Nbis.wsq().encoder("anelar-dir.bmp");
		Nbis.mindtct("anelar-dir.wsq");

		int bozorth3 = Nbis.bozorth3("anelar-dir.xyt", "anelar-dir.xyt");

		assertEquals(572, bozorth3);

	}

}
