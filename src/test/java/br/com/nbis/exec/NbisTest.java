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
	@Disabled
	void decoderWSQ() {
		
		
		Nbis.wsq().decoder();
		
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
		
		assertTrue(new File("anelar-dir.wsq.xyt").exists());
		
	}
	
	@Test
	void bozorth3() {
		
		Nbis.wsq().encoder("anelar-dir.png");
		Nbis.mindtct("anelar-dir.wsq");
		
		int bozorth3 = Nbis.bozorth3("anelar-dir.wsq.xyt", "anelar-dir.wsq.xyt");
		
		
		assertEquals(572, bozorth3);
				
	}
	
	
	
	
}
