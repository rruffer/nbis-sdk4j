package br.com.nbis.api.wsq;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.enums.Executables;
import br.com.nbis.exec.ExecRuntime;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;

public class WSQ {

	private final Logger log = LogManager.getLogger(getClass());
	
	private static WSQ instance;

	private WSQ() {

	}

	public static synchronized WSQ getInstance() {
		if (instance == null) {
			instance = new WSQ();
		}

		return instance;
	}

	public void decoder() {
		throw new UnsupportedOperationException("Método não implementado");
	}
	
	public void encoder() {
		throw new UnsupportedOperationException("Método não implementado");
	}

	public void encoder(String string) {
		
		File file = new File(string);
		
		Executables exec = Executables.CWSQ;
		
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