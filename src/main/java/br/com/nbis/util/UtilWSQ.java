package br.com.nbis.util;

import java.io.File;

public class UtilWSQ {

	private UtilWSQ() {
		
	}
	
	public static File teste(File imageFile) {
		return new File(imageFile.getAbsolutePath().substring(0, imageFile.getAbsolutePath().lastIndexOf(".")) + ".wsq");
	}
	
}
