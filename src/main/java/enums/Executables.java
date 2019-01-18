package enums;

import br.com.nbis.Commands;
import br.com.nbis.wsq.CommandsCWSQ;
import br.com.nbis.wsq.CommandsMINDTCT;
import br.com.nbis.wsq.CommandsNFIQ;

public enum Executables {

	BOZORTH3(null),
	CWSQ(new CommandsCWSQ()),
	DWSQ(null),
	MINDTCT(new CommandsMINDTCT()),
	NFIQ(new CommandsNFIQ());
	
	private Commands commands;
	
	private Executables(Commands commands) {
		this.commands = commands;
	}
	
	public Commands getCommands() {
		return commands;
	}
	
}
