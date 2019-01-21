package br.com.nbis.wsq;

import java.io.File;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandsMINDTCT implements Command{
	
	private final Logger log = LogManager.getLogger(getClass());

	@Override
	public String[] command(File... file) {
		String[] commands = null;
		
		File fileExec = file[0];
		File filePath = file[1];
		
		try {
			commands = Stream.of(fileExec.getAbsolutePath(), "-b", "-m1", filePath.getAbsolutePath(), filePath.getName()).toArray(String[]::new);
		} catch (Exception e) {
			log.error("Erro ao criar comando mindtct", e);
		}
		
		return commands;
	}

}
