package br.com.nbis.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class UtilFile {
	
	private UtilFile() {}
	
	public static boolean deletarDiretorios(File directoryToBeDeleted) throws Exception {
	    File[] allContents = directoryToBeDeleted.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
	        	deletarDiretorios(file);
	        }
	    }
	    return directoryToBeDeleted.delete();
	}
	
	public static void deletarDiretorios(String path) throws Exception {
			File file = new File(path);
			Stream<Path> walk = Files.walk(file.toPath());
			walk.sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
			walk.close();
	}

}
