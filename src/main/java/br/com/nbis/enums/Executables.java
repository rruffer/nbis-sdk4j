package br.com.nbis.enums;

import br.com.nbis.api.wsq.Command;
import br.com.nbis.api.wsq.CommandsBOZORTH3;
import br.com.nbis.api.wsq.CommandsCWSQ;
import br.com.nbis.api.wsq.CommandsDWSQ;
import br.com.nbis.api.wsq.CommandsMINDTCT;
import br.com.nbis.api.wsq.CommandsNFIQ;

public enum Executables {

	BOZORTH3(new CommandsBOZORTH3()),
	CWSQ(new CommandsCWSQ()),
	DWSQ(new CommandsDWSQ()),
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
