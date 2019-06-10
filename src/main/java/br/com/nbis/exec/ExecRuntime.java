package br.com.nbis.exec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.exeption.NbisException;

public class ExecRuntime {
	
	private ExecRuntime() {
		// classe de serviço
	}

	private static final Logger log = LogManager.getLogger(ExecRuntime.class);

	public static List<String> execRuntime(String[] commands) throws Exception {

		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(commands);

		try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()))) {
			
			List<String> listError = stdError.lines().collect(Collectors.toList());
			
			if(!listError.isEmpty()) {
				log.debug("Erro ao executar Comando: ");
				listError.forEach(System.out::println);
				throw new NbisException("");
			} else {
				
				return stdInput.lines().collect(Collectors.toList());
				
			}

			
			// read the output from the command
	/*		log.debug("Here is the standard output of the command: ");
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				log.debug(s);
			}

			// read any errors from the attempted command
			log.debug("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				log.debug(s);
			}*/

		} catch (Exception e) {
			log.error("Erro ao executar o runtime: ", e);
		} finally {
			//implementar
		}
		
		return null;
	}

}
