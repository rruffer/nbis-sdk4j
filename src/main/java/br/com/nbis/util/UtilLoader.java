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

import br.com.nbis.exeption.NbisException;

public class UtilLoader {

	private static final Logger log = LogManager.getLogger(UtilLoader.class);

	private UtilLoader() {
		// Classe de serviço
	}

	/**
	 * Carrrega os arquivos
	 * 
	 * @param fileName
	 * @return
	 */
	public static File getFile(String fileName) {

		File file = new File(UtilConstants.TEMP_DIR_NBIS + File.separator + "cwsq.exe");

		try (InputStream stream = UtilLoader.class.getResourceAsStream(fileName)){
			//file = File.createTempFile("tmp", null, null);
			log.debug(file.getAbsolutePath());
			FileUtils.copyInputStreamToFile(stream, file);
		} catch (Exception e) {
			log.error("Erro ao criar arquivo temporário: ", e);
		}

		return file;

	}

	/**
	 * Carrrega os arquivos
	 * 
	 * @param fileName
	 * @return
	 *//*
		 * public static File getFile(String fileName) {
		 * 
		 * InputStream stream = UtilLoader.class.getResourceAsStream(fileName); File
		 * file = null;
		 * 
		 * try { file = File.createTempFile("tmp", null, null);
		 * log.debug(file.getAbsolutePath()); FileUtils.copyInputStreamToFile(stream,
		 * file); } catch (Exception e) {
		 * log.error("Erro ao criar arquivo temporário: ", e); }
		 * 
		 * 
		 * return file;
		 * 
		 * }
		 */

	public static File copyFileForTempDir(String fileName) throws IOException {

		return copyFileForTempDir(new File(fileName));

	}

	public static File copyFileForTempDir(File srcFile) throws IOException {

		File baseDir = new File(UtilConstants.TEMP_DIR_NBIS);

		if (baseDir.exists()) {
			FileUtils.deleteDirectory(baseDir);
		}

		baseDir.mkdir();

		log.debug(baseDir.getAbsolutePath());

		// forma 1
		FileUtils.copyFileToDirectory(srcFile, baseDir);

		return new File(baseDir.getAbsolutePath() + File.separator + srcFile.getName());

	}

	public static File createFileInTempDir(byte[] img) throws IOException, NbisException {

		ContentType contentType = new ContentType(img);

		if (!contentType.getType().equals("image")) {
			throw new NbisException("Arquivo não é uma imagem!");
		}

		File baseDir = new File(UtilConstants.TEMP_DIR_NBIS);

		if (baseDir.exists()) {
			FileUtils.deleteDirectory(baseDir);
		}

		baseDir.mkdir();

		Path path = Paths.get(baseDir.getAbsolutePath() + File.separator + "outputWSQ." + contentType.getExtension());

		try {
			Files.write(path, img);
		} catch (IOException e) {
			log.error("Erro ao converter imagem: ", e);
		}

		return path.toFile();

	}

	/*
	 * public File getFile(String fileName) {
	 * 
	 * InputStream stream = getClass().getResourceAsStream(fileName); File file =
	 * null; try { // file = File.createTempFile("tmp", ".exe", new File("D:/"));
	 * file = File.createTempFile("tmp", null, null);
	 * log.debug(file.getAbsolutePath()); FileUtils.copyInputStreamToFile(stream,
	 * file); } catch (IOException e) {
	 * log.error("Erro ao criar arquivo temporário: ", e); }
	 * 
	 * 
	 * return file;
	 * 
	 * }
	 */

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
