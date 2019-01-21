package br.com.nbis.wsq;

import java.io.File;

public interface Command {

	String [] command(File... file);
	
}
