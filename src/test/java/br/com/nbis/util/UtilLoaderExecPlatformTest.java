package br.com.nbis.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.nbis.enums.Executables;

class UtilLoaderExecPlatformTest {

	@Test
	void test() {
		String pathFile = UtilLoaderExecPlatform.getPathfile(Executables.CWSQ);
		assertEquals("/win-64/bin/cwsq", pathFile.replace(".exe", ""));
	}

}
