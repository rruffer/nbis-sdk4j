package br.com.nbis.exec;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import br.com.nbis.api.Nbis;

/**
 * @link https://blog.travis-ci.com/2018-10-11-windows-early-release
 * @author rodolfo.mindtek
 *
 */
class VersionTest {
	
	@Test
	void version() {
		String version = Nbis.getVersion();
		
		assertNotNull(version);
		
		System.out.println(version);
	}

}
