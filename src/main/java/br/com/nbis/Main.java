package br.com.nbis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.println(System.getProperty("java.io.tmpdir"));

		File srcFile = new File("anelar-dir.png");
		File baseDir = new File(System.getProperty("java.io.tmpdir") + "nbis");

		baseDir.mkdir();

		System.out.println(baseDir.getAbsolutePath());

		// forma 1
		FileUtils.copyFileToDirectory(srcFile, baseDir);

		// forma 2
/*		Path copied = Paths.get(baseDir.getAbsolutePath() + File.separator + srcFile.getName());
		Files.copy(srcFile.toPath(), copied, StandardCopyOption.REPLACE_EXISTING);*/

		//deletar pasta
		FileUtils.deleteDirectory(baseDir);

	}

}
