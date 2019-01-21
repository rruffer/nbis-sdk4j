package br.com.nbis.mindtct;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.enums.Executables;
import br.com.nbis.exec.ExecRuntime;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;
import br.com.nbis.wsq.Command;

public class MINDTCT {
	
	private final Logger log = LogManager.getLogger(getClass());

	private static MINDTCT instance;

	private MINDTCT() {

	}

	public static synchronized MINDTCT getInstance() {
		if (instance == null) {
			instance = new MINDTCT();
		}

		return instance;
	}

	public void template(String img) {

		File file = new File(img);

		Executables exec = Executables.MINDTCT;

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
