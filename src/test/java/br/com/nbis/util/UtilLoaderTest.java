package br.com.nbis.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class UtilLoaderTest {

	@Test
	void pegarArquivo() throws IOException {

		File file = UtilLoader.getFileTest("anelar-dir.bmp");
		assertTrue(file.exists());

	}
	

}
