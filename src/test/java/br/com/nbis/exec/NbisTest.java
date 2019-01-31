package br.com.nbis.exec;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.nbis.api.Nbis;
import br.com.nbis.exeption.NbisException;

/**
 * @link https://blog.travis-ci.com/2018-10-11-windows-early-release
 * @author rodolfo.mindtek
 *
 */
class NbisTest {

	@Test
	void encoderStringBmpToWSQ() {

		try {
			assertTrue(Nbis.wsq().encoder("anelar-dir.bmp").getFile().exists());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Disabled
	void encoderStringTiffToWSQ() {
		
		try {
			assertTrue(Nbis.wsq().encoder("101_1.tiff").getFile().exists());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Disabled
	void encoderFileWSQ() {
		File file = new File("anelar-dir.bmp");
		
		try {
			Nbis.wsq().encoder(file);
			assertTrue(Nbis.wsq().encoder(file).getFile().exists());
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	
	@Test
	@Disabled
	void encoderByteArrayWSQ() {
		
		
		try {
			File file = new File("anelar-dir.bmp");
			byte[] readAllBytes = Files.readAllBytes(file.toPath());
			assertTrue(Nbis.wsq().encoder(readAllBytes).getFile().exists());
		} catch (NbisException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Test
	@Disabled
	void decoderWSQ() {

		try {
			Nbis.wsq().encoder("anelar-dir.bmp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Nbis.wsq().decoder("anelar-dir.wsq");

		assertTrue(new File("anelar-dir.raw").exists());
	}

	@Test
	@Disabled
	void nfiq() {

		try {
			Nbis.wsq().encoder("anelar-dir.bmp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int nfiq = Nbis.nfiq("anelar-dir.wsq");

		assertEquals(100, nfiq);

	}

	@Test
	@Disabled
	void mindtct() {

		try {
			Nbis.wsq().encoder("anelar-dir.bmp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Nbis.mindtct("anelar-dir.wsq");

		assertTrue(new File("anelar-dir.xyt").exists());

	}

	@Test
	@Disabled
	void bozorth3() {

		try {
			Nbis.wsq().encoder("anelar-dir.bmp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Nbis.mindtct("anelar-dir.wsq");

		int bozorth3 = Nbis.bozorth3("anelar-dir.xyt", "anelar-dir.xyt");

		assertEquals(572, bozorth3);

	}

}
