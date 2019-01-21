package br.com.nbis.exec;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.bozorth3.BOZORTH3;
import br.com.nbis.enums.Executables;
import br.com.nbis.mindtct.MINDTCT;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;
import br.com.nbis.wsq.Command;
import br.com.nbis.wsq.WSQ;
import br.com.nbis.nfiq.NFIQ;

public class Nbis {
	
	private final Logger log = LogManager.getLogger(getClass());

	public File execute(File filePath, Executables executables) {
		
		String outputName = filePath.getAbsolutePath().substring(0, filePath.getAbsolutePath().lastIndexOf(".")) + ".wsq";
		
		File outputFile = new File(outputName);
		
		String pathFile = UtilLoaderExecPlatform.getPathfile(executables);
		File fileExec = UtilLoader.getFile(pathFile);

		try {

			Command command = executables.getCommands();
			String[] commands = command.command(fileExec, filePath);

			ExecRuntime.execRuntime(commands);

		} catch (Exception e) {
			log.error("", e);
		} finally {
			fileExec.deleteOnExit();
		}
		
		return outputFile;

	}
	
	public static WSQ wsq() {
		return WSQ.getInstance();
	}
	
	public static int nfiq(String img) {
		return NFIQ.getInstance().quality(img);
		
	}
	
	public static void mindtct(String img) {
		MINDTCT.getInstance().template(img);
		
	}
	
	public static int bozorth3(String img1, String img2) {
		return BOZORTH3.getInstance().merge(img1, img2);
		
	}
	
	
	

}
