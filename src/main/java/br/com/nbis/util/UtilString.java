package br.com.nbis.util;

import java.io.File;

public class UtilString {
	
	private UtilString() {
		// classe de serviço
	}
	
	public static String removeExtension(File filePath) {

		String result = "";
		
		if(filePath != null) {
			
			result = filePath.getAbsolutePath().substring(0, filePath.getAbsolutePath().lastIndexOf("."));
		}
		
		return result;
	}
	
	public static String removeExtension(String name) {
		
		String result = "";
		
		if(name != null) {
			
			result = name.substring(0, name.lastIndexOf("."));
		}
		
		return result;
	}

}
