package br.com.nbis.enums;

import br.com.nbis.wsq.Command;
import br.com.nbis.wsq.CommandsBOZORTH3;
import br.com.nbis.wsq.CommandsCWSQ;
import br.com.nbis.wsq.CommandsMINDTCT;
import br.com.nbis.wsq.CommandsNFIQ;

public enum Executables {

	BOZORTH3(new CommandsBOZORTH3()),
	CWSQ(new CommandsCWSQ()),
	DWSQ(null),
	MINDTCT(new CommandsMINDTCT()),
	NFIQ(new CommandsNFIQ());
	
	private Command commands;
	
	private Executables(Command commands) {
		this.commands = commands;
	}
	
	public Command getCommands() {
		return commands;
	}
	
}
