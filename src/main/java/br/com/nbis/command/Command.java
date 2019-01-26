package br.com.nbis.command;

import java.io.File;

import br.com.nbis.exeption.NbisException;

public interface Command {

	String [] command(File... file) throws NbisException;
	
}
