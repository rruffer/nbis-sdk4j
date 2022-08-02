package br.com.nbis.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.enums.Executables;
import br.com.nbis.enums.Sistemas;
import br.com.nbis.enums.SistemasPath;
import br.com.nbis.enums.TypeExecutable;

public class UtilLoaderExecPlatform {
	
	private static final Logger log = LogManager.getLogger(UtilLoaderExecPlatform.class);
	
	private UtilLoaderExecPlatform() {

	}
	
	public static String getPathfile(Executables exec) {
		
		String pathFile = "";
		String nameFile = exec.name().toLowerCase();
		String typeFile = "";
		
		if(System.getProperty("os.name").toUpperCase().contains(Sistemas.WINDOWS.name())) {
			
			typeFile = "." + TypeExecutable.EXE.name().toLowerCase();
			
			if(System.getProperty("os.arch").contains("64")) {
				pathFile = SistemasPath.WINDOWS_X64.getPath();
			} else {
				pathFile = SistemasPath.WINDOWS_X32.getPath();
				
			}
			
		} else if (System.getProperty("os.name").toUpperCase().contains(Sistemas.LINUX.name())) {
			
			typeFile = "";
			
			if(System.getProperty("os.arch").contains("64")) {
				pathFile = SistemasPath.LINUX_X64.getPath();
			} else {
				pathFile = SistemasPath.LINUX_X32.getPath();
				
			}
			
		}
		
		pathFile =String.format("%s%s%s", pathFile, nameFile, typeFile);
		
		log.debug("Caminho do arquivo: {}", pathFile);
		
		return pathFile;
		

	}

	public static String getPathfileNfiq2(Executables exec) {
		
		String pathFile = "";
		String nameFile = exec.name().toLowerCase();
		String typeFile = "";
		
		if(System.getProperty("os.name").toUpperCase().contains(Sistemas.WINDOWS.name())) {
			
			typeFile = "." + TypeExecutable.EXE.name().toLowerCase();
			
			if(System.getProperty("os.arch").contains("64")) {
				pathFile = SistemasPath.WINDOWS_X64.getPath() + "/nfiq2";
			} else {
				pathFile = SistemasPath.WINDOWS_X32.getPath()  + "/nfiq2";
				
			}
			
		} else if (System.getProperty("os.name").toUpperCase().contains(Sistemas.LINUX.name())) {
			
			typeFile = "";
			
			if(System.getProperty("os.arch").contains("64")) {
				pathFile = SistemasPath.LINUX_X64.getPath()  + "/nfiq2";
			} else {
				pathFile = SistemasPath.LINUX_X32.getPath()  + "/nfiq2";
				
			}
			
		}
		
		pathFile =String.format("%s%s%s", pathFile, nameFile, typeFile);
		
		log.debug("Caminho do arquivo: {}", pathFile);
		
		return pathFile;
		
		
	}
	
	public static String getPathOS() {
		
		String pathFile = "";
		
		if(System.getProperty("os.name").toUpperCase().contains(Sistemas.WINDOWS.name())) {
			
			if(System.getProperty("os.arch").contains("64")) {
				pathFile = SistemasPath.WINDOWS_X64.getPath();
			} else {
				pathFile = SistemasPath.WINDOWS_X32.getPath();
				
			}
			
		} else if (System.getProperty("os.name").toUpperCase().contains(Sistemas.LINUX.name())) {
			
			if(System.getProperty("os.arch").contains("64")) {
				pathFile = SistemasPath.LINUX_X64.getPath();
			} else {
				pathFile = SistemasPath.LINUX_X32.getPath();
				
			}
			
		}
		
		log.debug("Caminho do arquivo: " + pathFile);
		
		return pathFile;
		
		
	}

}
