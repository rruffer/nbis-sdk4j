package br.com.nbis.util;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import enums.Executables;
import enums.Sistemas;
import enums.SistemasPath;
import enums.TypeExecutable;

public class UtilLoaderExecPlatform {
	
	private static final Logger log = LogManager.getLogger(UtilLoaderExecPlatform.class);
	
	public static String getPathfile(Executables exec) {
		
		String pathFile = "";
		String nameFile = exec.name().toLowerCase();
		String typeFile = "";
		
		if(System.getProperty("os.name").toUpperCase().contains(Sistemas.WINDOWS.name())) {
			
			typeFile = TypeExecutable.EXE.name().toLowerCase();
			
			if(System.getProperty("os.arch").contains("64")) {
				pathFile = SistemasPath.WINDOWS_X64.getPath();
			} else {
				pathFile = SistemasPath.WINDOWS_X32.getPath();
				
			}
			
		}
		
		pathFile =String.format("%s%s.%s", pathFile, nameFile, typeFile);
		
		log.debug("Caminho do arquivo: " + pathFile);
		
		return pathFile;
		

	}

}
