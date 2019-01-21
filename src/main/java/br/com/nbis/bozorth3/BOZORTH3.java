package br.com.nbis.bozorth3;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.enums.Executables;
import br.com.nbis.exec.ExecRuntime;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;
import br.com.nbis.wsq.Command;

public class BOZORTH3 {
	
	private final Logger log = LogManager.getLogger(getClass());

	private static BOZORTH3 instance;

	private BOZORTH3() {

	}

	public static synchronized BOZORTH3 getInstance() {
		if (instance == null) {
			instance = new BOZORTH3();
		}

		return instance;
	}
	
	public int merge(String img1, String img2) {
		
		int result = 0;

		File file1 = new File(img1);
		File file2 = new File(img2);

		Executables exec = Executables.BOZORTH3;

		String pathFile = UtilLoaderExecPlatform.getPathfile(exec);
		File fileExec = UtilLoader.getFile(pathFile);

		try {

			Command command = exec.getCommands();
			String[] commands = command.command(fileExec, file1, file2);

			List<String> execRuntime = ExecRuntime.execRuntime(commands);

			result = Integer.valueOf(execRuntime.get(0).split(" ")[0]);

		} catch (Exception e) {
			log.error("Erro ao codificar imagem: ", e);
		} finally {
			fileExec.deleteOnExit();
		}

		return result;
		
	}

}
