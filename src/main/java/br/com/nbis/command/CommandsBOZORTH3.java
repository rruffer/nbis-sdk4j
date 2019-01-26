package br.com.nbis.command;

import java.io.File;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandsBOZORTH3 implements Command{
	
	private final Logger log = LogManager.getLogger(getClass());

	@Override
	public String[] command(File... file) {
		String[] commands = null;
		
		File fileExec = file[0];
		File filePath1 = file[1];
		File filePath2 = file[2];
		
		try {
			//linha de comando bozorth3 -m1 -A outfmt=spg -T 20 -p db1/101_1.xyt db1/*.xyt
			commands = Stream.of(fileExec.getAbsolutePath(), "-b", "-m1", "-A", "outfmt=spg", "-T", "20", "-p", filePath1.getAbsolutePath(), filePath2.getAbsolutePath()).toArray(String[]::new);
		} catch (Exception e) {
			log.error("Erro ao criar comando nfiq", e);
		}
		
		return commands;
	}

}
