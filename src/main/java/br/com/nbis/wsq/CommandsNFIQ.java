package br.com.nbis.wsq;

import java.io.File;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.Commands;

public class CommandsNFIQ implements Commands{
	
	private final Logger log = LogManager.getLogger(getClass());

	@Override
	public String[] commands(File fileExec, File filePath) {
		String[] commands = null;
		
		try {
			commands = Stream.of(fileExec.getAbsolutePath(), filePath.getAbsolutePath()).toArray(String[]::new);
		} catch (Exception e) {
			log.error("Erro ao criar comando nfiq", e);
		}
		
		return commands;
	}

}
