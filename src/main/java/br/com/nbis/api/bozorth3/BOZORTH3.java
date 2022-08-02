package br.com.nbis.api.bozorth3;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.command.Command;
import br.com.nbis.enums.Executables;
import br.com.nbis.exec.ExecRuntime;
import br.com.nbis.exeption.NbisException;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;

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
		File file1 = new File(img1);
		File file2 = new File(img2);
		
		return merge(file1, file2);
	}
	
	public int merge(byte[] img1, byte[] img2) throws IOException, NbisException {
		File file1 = UtilLoader.createFileInTempDir(img1);
		File file2 = UtilLoader.createFileInTempDir(img2);
		return merge(file1, file2);
	}
	
	public int merge(File img1, File img2) {
		
		int result = 0;

		Executables exec = Executables.BOZORTH3;

		String pathFile = UtilLoaderExecPlatform.getPathfile(exec);
		File fileExec = UtilLoader.getFile(pathFile, exec);

		try {

			Command command = exec.getCommands();
			String[] commands = command.command(fileExec, img1, img2);

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
