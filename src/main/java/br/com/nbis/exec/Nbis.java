package br.com.nbis.exec;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.api.bozorth3.BOZORTH3;
import br.com.nbis.api.mindtct.MINDTCT;
import br.com.nbis.api.nfiq.NFIQ;
import br.com.nbis.api.wsq.Command;
import br.com.nbis.api.wsq.WSQ;
import br.com.nbis.enums.Executables;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;

/**
 * @link http://www.hjort.co/2015/12/evaluating-nbis-using-fvc2004-databases-part1.html
 * @link https://stackoverflow.com/questions/15464111/run-cmd-commands-through-java
 * @link https://coderanch.com/t/480489/java/ImageMagick-Java-Runtime-Exec
 * @link https://stackoverflow.com/questions/18010604/running-java-runtime-exec-for-multiple-process
 * @link https://www.developer.com/java/data/understanding-java-process-and-java-processbuilder.html
 * 
 * @author rodolfo.ruffer
 *
 */
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
