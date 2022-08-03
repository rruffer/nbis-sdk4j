package br.com.nbis.api.nfiq;

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

public class NFIQ2 {

	private final Logger log = LogManager.getLogger(getClass());

	private static NFIQ2 instance;
	
	private NFIQ2() {

	}

	public static synchronized NFIQ2 getInstance() {
		if (instance == null) {
			instance = new NFIQ2();
		}

		return instance;
	}

	public int quality(byte[] img) throws IOException, NbisException {
		File imageFile = UtilLoader.createFileInTempDir(img);
		return quality(imageFile);
	}
	
	public int quality(String img) {
		return quality(new File(img));
	}
	
	public int quality(File file) {
		
		int result = 0;
		
		Executables exec = Executables.NFIQ2;
		
		String pathFile = UtilLoaderExecPlatform.getPathfile(exec);
		File fileExec = UtilLoader.getFile(pathFile, exec);
		
		String pathOS = UtilLoaderExecPlatform.getPathOS();
		UtilLoader.setFileDll(pathOS, "Nfiq2Api.dll");
		
		try {
			
			Command command = exec.getCommands();
			String[] commands = command.command(fileExec, file);
			
			List<String> execRuntime = ExecRuntime.execRuntime(commands);
			
			result = Integer.parseInt(execRuntime.get(0));
			
		} catch (Exception e) {
			log.error("Erro ao codificar imagem: ", e);
		} finally {
			fileExec.deleteOnExit();
			file.delete();
		}
		
		return result;
		
	}

}
