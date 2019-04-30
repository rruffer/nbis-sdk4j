package br.com.nbis.utiltest;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtilLoader {

	private static final Logger log = LogManager.getLogger(UtilLoader.class);

	
	/**
	 * Carrrega os arquivos na pasta raíz. Só usado para testes
	 * @param fileName
	 * @param exec
	 * @return
	 */
	public static File getFileTest(String fileName) {

		File file = new File(System.getProperty("user.dir") + File.separator + fileName);

		try (InputStream stream = UtilLoader.class.getResourceAsStream("/img/" + fileName)) {
			FileUtils.copyInputStreamToFile(stream, file);
			file.setExecutable(true);
			file.setReadable(true);
			file.setWritable(true);
		} catch (Exception e) {
			log.error("Erro ao criar arquivo local: ", e);
		}

		return file;

	}

}
