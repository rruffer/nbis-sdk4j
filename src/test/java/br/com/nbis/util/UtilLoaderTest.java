package br.com.nbis.util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class UtilLoaderTest {
	
	@Test
	void pegarArquivo() {
		File file = UtilLoader.getFile("/img/anelar-dir.png");
		assertTrue(file.isFile());
		file.deleteOnExit();
	}


}
