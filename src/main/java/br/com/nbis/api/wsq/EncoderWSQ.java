package br.com.nbis.api.wsq;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tika.Tika;

import br.com.nbis.enums.Executables;
import br.com.nbis.exec.ExecRuntime;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;

public class EncoderWSQ {
	
	private final Logger log = LogManager.getLogger(getClass());
	
	public void encoder(String img) {
		encoder(new File(img));
		
	}

	public void encoder(byte[] img) {
		
		String contentType = new Tika().detect(img);
		
		File temp = new File(System.getProperty("java.io.tmpdir") + "nbis");
		temp.mkdir();
		Path path = Paths.get(temp.getAbsolutePath() + File.separator + "teste." + contentType.split("/")[1]);
		try {
			Files.write(path, img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		encoder(new File(System.getProperty("java.io.tmpdir") + "nbis" + File.separator + "teste." + contentType.split("/")[1]));
		
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

	
}
