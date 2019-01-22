package br.com.nbis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.tika.Tika;

/**
 * {@link} https://www.geeksforgeeks.org/jvm-shutdown-hook-java/
 * @author rodolfo.mindtek
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {

//		System.out.println(System.getProperty("java.io.tmpdir"));
//
//		File srcFile = new File("anelar-dir.png");
//		File baseDir = new File(System.getProperty("java.io.tmpdir") + "nbis");
//
//		baseDir.mkdir();
//
//		System.out.println(baseDir.getAbsolutePath());
//
//		// forma 1
//		FileUtils.copyFileToDirectory(srcFile, baseDir);

		// forma 2
/*		Path copied = Paths.get(baseDir.getAbsolutePath() + File.separator + srcFile.getName());
		Files.copy(srcFile.toPath(), copied, StandardCopyOption.REPLACE_EXISTING);*/

		//deletar pasta
//		FileUtils.deleteDirectory(baseDir);
//		
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			@Override
//			public void run() {
//				System.out.println("Shutdown Hook is running !");
//			}
//		});
//		
//		System.out.println("Application Terminating ..."); 

		
		File file = new File("anelar-dir.wsq");
		byte[] img = Files.readAllBytes(file.toPath());
		
		String contentType = new Tika().detect(img);
		
		System.out.println(contentType);
		
	}

}
