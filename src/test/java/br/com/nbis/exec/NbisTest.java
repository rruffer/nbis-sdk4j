package br.com.nbis.exec;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class NbisTest {
	
	

	@Test
	@Disabled
	void encoderWSQ() {
		
		
		Nbis.wsq().encoder("anelar-dir.png");
		
		assertTrue(new File("anelar-dir.wsq").exists());
		
	}
	
	@Test
	void decoderWSQ() {
		
		Nbis.wsq().encoder("anelar-dir.png");
		
		Nbis.wsq().decoder("anelar-dir.wsq");
		
		assertTrue(new File("anelar-dir.raw").exists());
	}
	
	@Test
	@Disabled
	void nfiq() {
		
		Nbis.wsq().encoder("anelar-dir.png");
		
		int nfiq = Nbis.nfiq("anelar-dir.wsq");
		
		assertEquals(100, nfiq);
		
	}
	
	@Test
	@Disabled
	void mindtct() {
		
		Nbis.wsq().encoder("anelar-dir.png");
		Nbis.mindtct("anelar-dir.wsq");
		
		assertTrue(new File("anelar-dir.xyt").exists());
		
	}
	
	@Test
	@Disabled
	void bozorth3() {
		
		Nbis.wsq().encoder("anelar-dir.png");
		Nbis.mindtct("anelar-dir.wsq");
		
		int bozorth3 = Nbis.bozorth3("anelar-dir.xyt", "anelar-dir.xyt");
		
		
		assertEquals(572, bozorth3);
				
	}
	
	
	
	
}
