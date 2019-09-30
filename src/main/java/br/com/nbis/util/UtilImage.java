package br.com.nbis.util;

import java.io.FileOutputStream;

public class UtilImage {
	
	private UtilImage() {

	}
	
	public static void write(String fileName, byte[] image) throws Exception {
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName);
			fos.write(image);
		} finally {
			fos.close();
		}
	}

}
