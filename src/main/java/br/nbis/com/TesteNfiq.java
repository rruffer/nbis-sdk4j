package br.nbis.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @link http://www.hjort.co/2015/12/evaluating-nbis-using-fvc2004-databases-part1.html
 * @author rodolfo.ruffer
 *
 */
public class TesteNfiq {

	public static void main(String[] args) throws Exception {

		File f = new File("digital.wsq");
		File file = new TesteNfiq().getFile("win-64/bin/nfiq.exe");

		Runtime rt = Runtime.getRuntime();
		String[] commands = { file.getAbsolutePath(), f.getAbsolutePath() };
		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		// read the output from the command
		System.out.print("Here is the standard output of the command: ");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			System.out.println(getQualidade(s));
		}

		// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}

	}

	private File getFile(String fileName) {

		File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

		return file;

	}

	private static int getQualidade(String nfiq) {
		
		int num = Integer.parseInt(nfiq);
		
		switch (num) {
		case 1:
			return 100;
		case 2:
			return 80;
		case 3:
			return 60;
		case 4:
			return 40;
		case 5:
			return 20;
		default:
			return 0;
		}
	}
}
