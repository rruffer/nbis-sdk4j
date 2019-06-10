package br.com.nbis.command;

import java.io.File;
import java.util.stream.Stream;

import br.com.nbis.exeption.NbisException;
import br.com.nbis.util.UtilString;

public class CommandsMINDTCT implements Command{
	
	@Override
	public String[] command(File... file) throws NbisException {
		
		File fileExec = file[0];
		File filePath = file[1];
		
		//linha de comando mindtct.exe -b -m1 digital.wsq digital
		return Stream.of(fileExec.getAbsolutePath(), "-b", "-m1", filePath.getAbsolutePath(), UtilString.removeExtension(filePath.getAbsolutePath())).toArray(String[]::new);
//		return Stream.of(fileExec.getAbsolutePath(), "-b", "-m1", filePath.getAbsolutePath(), UtilString.removeExtension(filePath.getName())).toArray(String[]::new);
		
	}

}
