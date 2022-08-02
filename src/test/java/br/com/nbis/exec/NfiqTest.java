package br.com.nbis.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.nbis.api.Nbis;
import br.com.nbis.utiltest.UtilLoader;

/**
 * @link https://blog.travis-ci.com/2018-10-11-windows-early-release
 * @author rodolfo.mindtek
 *
 */
@DisplayName("Testes nfiq")
class NfiqTest {

	static File image = null;
	static String nameFile = "anelar-esq.bmp";

	@BeforeEach
	void setup() {
		image = UtilLoader.getFileTest(nameFile);
	}

	@Test
	@DisplayName("Teste com byte array")
	void nfiqByteArray() throws Exception {

		byte[] img = Files.readAllBytes(image.toPath());
		byte[] arrayWsq = Nbis.wsq().encoder(img).getByteArray();
		int nfiq = Nbis.nfiq(arrayWsq);
		assertEquals(40, nfiq);

	}

	@Test
	@DisplayName("Teste com file")
	void nfiqFile() throws Exception {

		File fileWsq = Nbis.wsq().encoder(image).getFile();
		int nfiq = Nbis.nfiq(fileWsq);
		assertEquals(40, nfiq);

	}

	@Test
	@DisplayName("Teste com path string")
	void nfiqString() throws Exception {

		File fileWsq = Nbis.wsq().encoder(nameFile).getFile();
		int nfiq = Nbis.nfiq(fileWsq);
		assertEquals(40, nfiq);

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
