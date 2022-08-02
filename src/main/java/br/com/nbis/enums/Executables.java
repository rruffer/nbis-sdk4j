package br.com.nbis.enums;

import br.com.nbis.command.Command;
import br.com.nbis.command.CommandsBOZORTH3;
import br.com.nbis.command.CommandsCWSQ;
import br.com.nbis.command.CommandsDWSQ;
import br.com.nbis.command.CommandsMINDTCT;
import br.com.nbis.command.CommandsNFIQ;

public enum Executables {

	BOZORTH3(new CommandsBOZORTH3()),
	CWSQ(new CommandsCWSQ()),
	DWSQ(new CommandsDWSQ()),
	MINDTCT(new CommandsMINDTCT()),
	NFIQ(new CommandsNFIQ()),
	NFIQ2(new CommandsNFIQ());
	
	private Command commands;
	
	private Executables(Command commands) {
		this.commands = commands;
	}
	
	public Command getCommands() {
		return commands;
	}
	
}
