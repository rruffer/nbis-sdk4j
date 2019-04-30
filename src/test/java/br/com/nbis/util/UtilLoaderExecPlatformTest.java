package br.com.nbis.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import br.com.nbis.enums.Executables;
import br.com.nbis.interfaces.TestWindows64;

class UtilLoaderExecPlatformTest {

	@Test
	@EnabledOnOs(OS.WINDOWS)
	@EnabledIfSystemProperty(named="os.arch", matches=".*32.*")
	void testWindows32() {
		String pathfile = UtilLoaderExecPlatform.getPathfile(Executables.CWSQ);
		assertEquals("/win-32/bin/cwsq.exe", pathfile);
	}
	
	@TestWindows64
	void testWindows64() {
		String pathfile = UtilLoaderExecPlatform.getPathfile(Executables.CWSQ);
		assertEquals("/win-64/bin/cwsq.exe", pathfile);
	}
	@Test
	@EnabledOnOs(OS.LINUX)
	@EnabledIfSystemProperty(named="os.arch", matches=".*32.*")
	void testLinux32() {
		String pathfile = UtilLoaderExecPlatform.getPathfile(Executables.CWSQ);
		assertEquals("/linux-32/bin/cwsq", pathfile);
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	void testLinux64() {
		String pathfile = UtilLoaderExecPlatform.getPathfile(Executables.CWSQ);
		assertEquals("/linux-64/bin/cwsq", pathfile);
	}

}
