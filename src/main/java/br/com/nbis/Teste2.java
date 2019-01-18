package br.com.nbis;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Teste2 {

	public static void main(String[] args) throws Exception {
		
		File f = new File("digital.jpg");
		File file = new Teste2().getFile("win-64/bin/cjpegl.exe");
		
		System.out.println(f.getAbsolutePath() +" d.wsq");
		
/*		String domainName = "google.com";
		
		//in mac oxs
		String com = "ping " + domainName;*/
		
		Runtime rt = Runtime.getRuntime();
		String[] commands = {file.getAbsolutePath(), "jpl", f.getAbsolutePath() ,"-r", "768,4718592,24"};
		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new 
		     InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new 
		     InputStreamReader(proc.getErrorStream()));

		// read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
		    System.out.println(s);
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

}
