package br.com.nbis.util;

import java.io.File;

public class UtilWSQ {

	private UtilWSQ() {
		
	}
	
	public static File fileWsq(File imageFile) {
		return new File(imageFile.getAbsolutePath().substring(0, imageFile.getAbsolutePath().lastIndexOf(".")) + ".wsq");
	}
	
	public static File fileXyt(File imageFile) {
		return new File(imageFile.getAbsolutePath().substring(0, imageFile.getAbsolutePath().lastIndexOf(".")) + ".xyt");
	}
	
	public static File fileNcm(File imageFile) {
		return new File(imageFile.getAbsolutePath().substring(0, imageFile.getAbsolutePath().lastIndexOf(".")) + ".ncm");
	}
	
	public static File fileRaw(File imageFile) {
		return new File(imageFile.getAbsolutePath().substring(0, imageFile.getAbsolutePath().lastIndexOf(".")) + ".raw");
	}
	
}
