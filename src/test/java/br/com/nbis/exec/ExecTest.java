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
		
		File file = UtilLoader.getFile("/img/anelar-dir.png");
		
		File execute = exec.execute(file, Executables.CWSQ);
		
		assertTrue(execute.exists());
		
		
	}

}
