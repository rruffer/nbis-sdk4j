package br.nbis.com.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class DLL_Setup {

	public File getFile(String fileName) {
		
		InputStream stream = getClass().getResourceAsStream(fileName);
		File file = null;
		try {
//			file = File.createTempFile("tmp", ".exe", new File("D:/"));
			file = File.createTempFile("tmp", null, null);
			System.out.println(file.getAbsolutePath());
			FileUtils.copyInputStreamToFile(stream, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return file;
		
	}
	
}

