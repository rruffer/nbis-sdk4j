package br.com.nbis.exec;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.nbis.api.Nbis;
import br.com.nbis.exeption.NbisException;
import br.com.nbis.util.UtilImage;
import br.com.nbis.utiltest.UtilLoader;

/**
 * @link https://blog.travis-ci.com/2018-10-11-windows-early-release
 * @author rodolfo.mindtek
 *
 */
class WSQEncoderTest {
	
	static File image = null;
	static String nameFile = "anelar-esq.bmp";
	
	@BeforeAll
	static void startAll() {
		image =  UtilLoader.getFileTest(nameFile);
	}

	@Test
	void encoderStringBmpToWSQ() {

		try {
			assertTrue(Nbis.wsq().encoder(nameFile).getFile().exists());
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
	void encoderFileWSQ() {
		File file = new File(nameFile);
		
		try {
			assertTrue(Nbis.wsq().encoder(file).getFile().exists());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	void encoderByteArrayWSQ() {
		
		try {
			File file = new File(nameFile);
			byte[] readAllBytes = Files.readAllBytes(file.toPath());
			assertTrue(Nbis.wsq().encoder(readAllBytes).getFile().exists());
		} catch (NbisException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void gravarArquivoWSQ() {
		
		try {
			byte[] array = Nbis.wsq().encoder(image).getByteArray();
			
			File file = new File("teste.wsq");
			UtilImage.write(file.getAbsolutePath(), array);
			
			assertTrue(file.exists());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@AfterAll
	static void endDownAll() {
		image.delete();
	}

}
