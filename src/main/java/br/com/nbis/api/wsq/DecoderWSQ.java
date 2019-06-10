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

public class DecoderWSQ {

	private final Logger log = LogManager.getLogger(getClass());

	private File imageFile;
	private File outputFileNcm;
	private File outputFileRaw;

	public DecoderWSQ() {

	}

	public DecoderWSQ(String img) throws IOException {
		this.imageFile = UtilLoader.copyFileForTempDir(img);
		this.outputFileNcm = UtilWSQ.fileNcm(imageFile);
		this.outputFileRaw = UtilWSQ.fileRaw(imageFile);
		decoder();
	}

	public DecoderWSQ(File img) throws IOException {
		this.imageFile = UtilLoader.copyFileForTempDir(img);
		this.outputFileNcm = UtilWSQ.fileNcm(imageFile);
		this.outputFileRaw = UtilWSQ.fileRaw(imageFile);
		decoder();
	}

	public DecoderWSQ(byte[] img) throws IOException, NbisException {
		this.imageFile = UtilLoader.createFileInTempDir(img);
		this.outputFileNcm = UtilWSQ.fileNcm(imageFile);
		this.outputFileRaw = UtilWSQ.fileRaw(imageFile);
		decoder();
	}

	public File getFileNcm() {
		return this.outputFileNcm;
	}

	public byte[] getByteArrayNcm() throws IOException {
		return Files.readAllBytes(this.outputFileNcm.toPath());
	}
	
	public File getFileRaw() {
		return this.outputFileRaw;
	}
	
	public byte[] getByteArrayRaw() throws IOException {
		return Files.readAllBytes(this.outputFileRaw.toPath());
	}
	
	private void decoder() {
		
		Executables exec = Executables.DWSQ;
		
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
