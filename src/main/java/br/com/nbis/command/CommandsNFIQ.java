package br.com.nbis.command;

import java.io.File;
import java.util.stream.Stream;

import br.com.nbis.exeption.NbisException;

public class CommandsNFIQ implements Command {

	@Override
	public String[] command(File... file) throws NbisException {

		File fileExec = file[0];
		File filePath = file[1];

		return Stream.of(fileExec.getAbsolutePath(), filePath.getAbsolutePath()).toArray(String[]::new);
	}

}
