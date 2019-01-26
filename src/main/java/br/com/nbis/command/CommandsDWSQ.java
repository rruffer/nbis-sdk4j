package br.com.nbis.api.wsq;

import java.io.File;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandsDWSQ implements Command {

	private final Logger log = LogManager.getLogger(getClass());

	@Override
	public String[] command(File... file) {
		
		File fileExec = file[0];
		File filePath = file[1];

		String[] commands = Stream.of(fileExec.getAbsolutePath(), "raw", filePath.getAbsolutePath(), "-r")
				.toArray(String[]::new);

		return commands;
	}

}
