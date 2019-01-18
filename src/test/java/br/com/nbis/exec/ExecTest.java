package br.com.nbis.exec;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import br.com.nbis.util.UtilLoader;
import enums.Executables;

class ExecTest {

	@Test
	void executeCWSQ() {
		
		
		Exec exec = new Exec();
		
//		File file = UtilLoader.getFile("/img/anelar-dir.png");
		File file = new File("anelar-dir.png");
		
		File execute = exec.execute(file, Executables.CWSQ);
		
		assertTrue(execute.exists());
		
		
	}
	
	@Test
	void executeNFIQ() {

		Exec exec = new Exec();

//		File file = UtilLoader.getFile("/img/anelar-dir.png");
		File file = new File("anelar-dir.png");
		File fileWSQ = new File("anelar-dir.wsq");
		
		exec.execute(file, Executables.CWSQ);
		exec.execute(fileWSQ, Executables.NFIQ);

//		assertTrue(execute.exists());

	}
	
	@Test
	void executeMINDTCT() {
		
		Exec exec = new Exec();
		
//		File file = UtilLoader.getFile("/img/anelar-dir.png");
		File file = new File("anelar-dir.png");
		File fileWSQ = new File("anelar-dir.wsq");
		
		exec.execute(file, Executables.CWSQ);
		exec.execute(fileWSQ, Executables.NFIQ);
		exec.execute(fileWSQ, Executables.MINDTCT);
		
//		assertTrue(execute.exists());
		
	}

}
