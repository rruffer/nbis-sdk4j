package br.com.nbis.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExecRuntime {

	private static final Logger log = LogManager.getLogger(ExecRuntime.class);

	public static void execRuntime(String[] commands) throws IOException {

		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(commands);

		try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()))) {

			// read the output from the command
			log.debug("Here is the standard output of the command: ");
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				log.debug(s);
			}

			// read any errors from the attempted command
			log.debug("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				log.debug(s);
			}

		} catch (Exception e) {
			log.error("Erro ao executar o runtime: ", e);
		}
	}

}
