package br.com.nbis.api.wsq;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tika.Tika;

import br.com.nbis.command.Command;
import br.com.nbis.enums.Executables;
import br.com.nbis.exec.ExecRuntime;
import br.com.nbis.exeption.NbisException;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;
import br.com.nbis.util.UtilWSQ;

public class EncoderWSQ {

	private final Logger log = LogManager.getLogger(getClass());

	private File imageFile;
	private File outputFile;

	public EncoderWSQ() {

	}

	public EncoderWSQ(String img) throws IOException {
		this.imageFile = UtilLoader.copyFileForTempDir(img);
		this.outputFile = UtilWSQ.teste(imageFile);
		encoder();
	}

	public EncoderWSQ(File img) throws IOException {
		this.imageFile = UtilLoader.copyFileForTempDir(img);
		this.outputFile = UtilWSQ.teste(imageFile);
		encoder();

	}

	public EncoderWSQ(byte[] img) throws IOException, NbisException {
		this.imageFile = UtilLoader.createFileInTempDir(img);
		this.outputFile = UtilWSQ.teste(imageFile);
		encoder();
	}

	public File getFile() {
		return this.outputFile;
	}

	public byte[] getByteArray() throws IOException {
		return Files.readAllBytes(this.outputFile.toPath());
	}

	public void encoder(byte[] img) {

		String contentType = new Tika().detect(img);

		File temp = new File(System.getProperty("java.io.tmpdir") + "nbis");
		temp.mkdir();
		Path path = Paths.get(temp.getAbsolutePath() + File.separator + "teste." + contentType.split("/")[1]);

		try {
			Files.write(path, img);
		} catch (IOException e) {
			log.error("Erro ao converter imagem: ", e);
		}

		encoder(new File(
				System.getProperty("java.io.tmpdir") + "nbis" + File.separator + "teste." + contentType.split("/")[1]));

	}

	public void encoder(File img) {

		Executables exec = Executables.CWSQ;
		String pathFile = UtilLoaderExecPlatform.getPathfile(exec);
		File fileExec = UtilLoader.getFile(pathFile);

		try {
			Command command = exec.getCommands();
			String[] commands = command.command(fileExec, img);
			ExecRuntime.execRuntime(commands);
		} catch (Exception e) {
			log.error("Erro ao codificar imagem: ", e);
		} finally {
			fileExec.deleteOnExit();
		}

	}

	private void encoder() {

		Executables exec = Executables.CWSQ;
		String pathFile = UtilLoaderExecPlatform.getPathfile(exec);
		File fileExec = UtilLoader.getFile(pathFile);

		try {
			Command command = exec.getCommands();
			String[] commands = command.command(fileExec, imageFile);
			ExecRuntime.execRuntime(commands);
		} catch (Exception e) {
			log.error("Erro ao codificar imagem: ", e);
		} finally {
			fileExec.deleteOnExit();
		}
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
