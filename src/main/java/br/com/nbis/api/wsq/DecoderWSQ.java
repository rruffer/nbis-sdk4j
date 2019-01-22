package br.com.nbis.api.wsq;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.enums.Executables;
import br.com.nbis.exec.ExecRuntime;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;

public class DecoderWSQ {
	
	private final Logger log = LogManager.getLogger(getClass());
	
	public void decoder(String string) {
		
		File file = new File(string);
		
		Executables exec = Executables.DWSQ;
		
		String pathFile = UtilLoaderExecPlatform.getPathfile(exec);
		File fileExec = UtilLoader.getFile(pathFile);
		
		try {
			
			
			Command command = exec.getCommands();
			String[] commands = command.command(fileExec, file);
			
			ExecRuntime.execRuntime(commands);
			
		} catch (Exception e) {
			log.error("Erro ao codificar imagem: ", e);
		} finally {
			fileExec.deleteOnExit();
		}
		
	}
	
}
