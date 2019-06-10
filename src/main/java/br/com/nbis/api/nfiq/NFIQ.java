package br.com.nbis.api.nfiq;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.command.Command;
import br.com.nbis.enums.Executables;
import br.com.nbis.exec.ExecRuntime;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;

public class NFIQ {

	private final Logger log = LogManager.getLogger(getClass());

	private static NFIQ instance;

	private NFIQ() {

	}

	public static synchronized NFIQ getInstance() {
		if (instance == null) {
			instance = new NFIQ();
		}

		return instance;
	}

	public int quality(String img) {

		int result = 0;

		File file = new File(img);

		Executables exec = Executables.NFIQ;

		String pathFile = UtilLoaderExecPlatform.getPathfile(exec);
		File fileExec = UtilLoader.getFile(pathFile, exec);

		try {

			Command command = exec.getCommands();
			String[] commands = command.command(fileExec, file);

			List<String> execRuntime = ExecRuntime.execRuntime(commands);

			result = getQualidade(execRuntime.get(0));

		} catch (Exception e) {
			log.error("Erro ao codificar imagem: ", e);
		} finally {
			fileExec.deleteOnExit();
		}

		return result;

	}
	
	public int quality(File file) {
		
		int result = 0;
		
		Executables exec = Executables.NFIQ;
		
		String pathFile = UtilLoaderExecPlatform.getPathfile(exec);
		File fileExec = UtilLoader.getFile(pathFile, exec);
		
		try {
			
			Command command = exec.getCommands();
			String[] commands = command.command(fileExec, file);
			
			List<String> execRuntime = ExecRuntime.execRuntime(commands);
			
			result = getQualidade(execRuntime.get(0));
			
		} catch (Exception e) {
			log.error("Erro ao codificar imagem: ", e);
		} finally {
			fileExec.deleteOnExit();
		}
		
		return result;
		
	}

	private int getQualidade(String nfiq) {

		int num = Integer.parseInt(nfiq);

		switch (num) {
		case 1:
			return 100;
		case 2:
			return 80;
		case 3:
			return 60;
		case 4:
			return 40;
		case 5:
			return 20;
		default:
			return 0;
		}
	}

}
