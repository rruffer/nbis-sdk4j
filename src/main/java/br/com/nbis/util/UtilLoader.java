package br.com.nbis.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tika.Tika;

import br.com.nbis.enums.Executables;
import br.com.nbis.exeption.NbisException;

public class UtilLoader {

	private static final Logger log = LogManager.getLogger(UtilLoader.class);

	private UtilLoader() {
		// Classe de serviço
	}

	/**
	 * Carrrega os arquivos executáveis
	 * @param fileName
	 * @param exec
	 * @return
	 */
	public static File getFile(String fileName, Executables exec) {

		File file = new File(UtilConstants.TEMP_DIR_NBIS + File.separator + exec.name().toLowerCase());

		try (InputStream stream = UtilLoader.class.getResourceAsStream(fileName)) {
			// file = File.createTempFile("tmp", null, null);
			log.debug(file.getAbsolutePath());
			FileUtils.copyInputStreamToFile(stream, file);
			file.setExecutable(true);
			file.setReadable(true);
			file.setWritable(true);
		} catch (Exception e) {
			log.error("Erro ao criar arquivo temporário: ", e);
		}

		return file;

	}


	public static File copyFileForTempDir(String fileName) throws IOException {

		return copyFileForTempDir(new File(fileName));

	}

	public static File copyFileForTempDir(File srcFile) throws IOException {

		File tempDir = createTempDir();

		log.debug(tempDir.getAbsolutePath());

		FileUtils.copyFileToDirectory(srcFile, tempDir);

		return new File(tempDir.getAbsolutePath() + File.separator + srcFile.getName());

	}

	public static File createFileInTempDir(byte[] img) throws IOException, NbisException {

		ContentType contentType = new ContentType(img);

		if (!contentType.getType().equals("image")) {
			throw new NbisException("Arquivo não é uma imagem!");
		}
		File tempDir = createTempDir();

		Path path = Paths.get(tempDir.getAbsolutePath() + File.separator + "outputWSQ." + contentType.getExtension());

		try {
			Files.write(path, img);
		} catch (IOException e) {
			log.error("Erro ao converter imagem: ", e);
		}

		return path.toFile();

	}

	public static File createTempDir() throws IOException {
		File tempDir = new File(UtilConstants.TEMP_DIR_NBIS);

		/*
		 * if (baseDir.exists()) { FileUtils.deleteDirectory(baseDir); }
		 */

		tempDir.mkdir();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					FileUtils.deleteDirectory(tempDir);
					log.debug("Apaguei a pasta !");
				} catch (IOException e) {
					log.error("Erro ao criar pasta temporária", e);
				}
			}
		});
		
		return tempDir;
	}

}

class ContentType {

	private String type;
	private String extension;

	public ContentType(byte[] img) {
		String contentType = new Tika().detect(img);
		String[] array = contentType.split("/");
		this.type = array[0];
		this.extension = array[1];
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

}
