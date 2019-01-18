package br.com.nbis.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.io.FileUtils;

public class UtilLoader {
	
	private static final Logger log = LogManager.getLogger(UtilLoader.class);

	private UtilLoader() {
		// Classe de serviço
	}
	
	/**
	 * Carrrega os arquivos
	 * @param fileName
	 * @return
	 */
	public static File getFile(String fileName) {
		
		InputStream stream = UtilLoader.class.getResourceAsStream(fileName);
		File file = null;
		
		try {
			file = File.createTempFile("tmp", null, null);
			log.debug(file.getAbsolutePath());
			FileUtils.copyInputStreamToFile(stream, file);
		} catch (Exception e) {
			log.error("Erro ao criar arquivo temporário: ", e);
		}
		
		
		return file;
		
	}
	
	/*public File getFile(String fileName) {
		
		InputStream stream = getClass().getResourceAsStream(fileName);
		File file = null;
		try {
//			file = File.createTempFile("tmp", ".exe", new File("D:/")); 
			file = File.createTempFile("tmp", null, null);
			log.debug(file.getAbsolutePath());
			FileUtils.copyInputStreamToFile(stream, file);
		} catch (IOException e) {
			log.error("Erro ao criar arquivo temporário: ", e);
		}
		
		
		return file;
		
	}*/
	
}

