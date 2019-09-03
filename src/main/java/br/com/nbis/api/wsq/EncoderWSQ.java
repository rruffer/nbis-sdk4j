package br.com.nbis.api.wsq;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		this.outputFile = UtilWSQ.fileWsq(imageFile);
		encoder();
	}

	public EncoderWSQ(File img) throws IOException {
		this.imageFile = UtilLoader.copyFileForTempDir(img);
		this.outputFile = UtilWSQ.fileWsq(imageFile);
		encoder();

	}

	public EncoderWSQ(byte[] img) throws IOException, NbisException {
		this.imageFile = UtilLoader.createFileInTempDir(img);
		this.outputFile = UtilWSQ.fileWsq(imageFile);
		encoder();
	}

	public File getFile() {
		return this.outputFile;
	}

	public byte[] getByteArray() throws IOException {
		return Files.readAllBytes(this.outputFile.toPath());
	}

	private void encoder() {

		Executables exec = Executables.CWSQ;
		String pathFile = UtilLoaderExecPlatform.getPathfile(exec);
		File fileExec = UtilLoader.getFile(pathFile, exec);

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
