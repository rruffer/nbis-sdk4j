package br.com.nbis.api.wsq;

import java.io.File;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandsNFIQ implements Command{
	
	private final Logger log = LogManager.getLogger(getClass());

	@Override
	public String[] command(File... file) {
		String[] commands = null;
		
		File fileExec = file[0];
		File filePath = file[1];
		
		try {
			commands = Stream.of(fileExec.getAbsolutePath(), filePath.getAbsolutePath()).toArray(String[]::new);
		} catch (Exception e) {
			log.error("Erro ao criar comando nfiq", e);
		}
		
		return commands;
	}

}
