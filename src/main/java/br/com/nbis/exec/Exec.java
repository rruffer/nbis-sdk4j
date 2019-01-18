package br.com.nbis.exec;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.Commands;
import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;
import br.com.nbis.wsq.CommandsCWSQ;
import enums.Executables;

public class Exec {
	
	private final Logger log = LogManager.getLogger(getClass());

	public File execute(File filePath, Executables executables) {
		
		String outputName = filePath.getAbsolutePath().substring(0, filePath.getAbsolutePath().lastIndexOf(".")) + ".wsq";
		
		File outputFile = new File(outputName);
		
		String pathFile = UtilLoaderExecPlatform.getPathfile(executables);
		File fileExec = UtilLoader.getFile(pathFile);

		try {

			
			Commands command = new CommandsCWSQ();
			String[] commands = command.commands(fileExec, filePath);

			ExecRuntime.execRuntime(commands);

		} catch (IOException e) {
			log.error("", e);
		} finally {
			fileExec.deleteOnExit();
		}
		
		return outputFile;

	}

}
