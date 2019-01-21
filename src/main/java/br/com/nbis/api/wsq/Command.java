package br.com.nbis.api.wsq;

import java.io.File;

public interface Command {

	String [] command(File... file);
	
}
