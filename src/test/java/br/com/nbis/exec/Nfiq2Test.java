package br.com.nbis.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.nbis.api.Nbis;
import br.com.nbis.exeption.NbisException;
import br.com.nbis.utiltest.UtilLoader;

/**
 * @link https://blog.travis-ci.com/2018-10-11-windows-early-release
 * @author rodolfo.mindtek
 *
 */
@DisplayName("Testes nfiq")
class Nfiq2Test {
	
	static File image = null;
	static String nameFile = "exemplo.bmp";
	
	@BeforeEach
	void setup() {
		image =  UtilLoader.getFileTest(nameFile);
	}

	@Test
	@DisplayName("Teste com byte array")
	void nfiqByteArray() {

		try {
			byte[] img = Files.readAllBytes(image.toPath());
			int nfiq = Nbis.nfiq2(img);

			assertEquals(69, nfiq);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NbisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	@Test
	@DisplayName("Teste com file")
	void nfiqFile() {

		int nfiq = Nbis.nfiq2(image);
		assertEquals(69, nfiq);


	}
	
	@Test
	@DisplayName("Teste com path string")
	void nfiqString() {
		
		int nfiq = Nbis.nfiq2(nameFile);
		assertEquals(69, nfiq);
		
		
	}
	
	@AfterEach
	void clean() {
		image.delete();
	}

	@AfterAll
	static void finish() {
		Nbis.close();
	}

}
