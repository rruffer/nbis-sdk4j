package br.com.nbis;

import static java.lang.System.out;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.apache.tika.Tika;
import org.apache.tika.metadata.TIFF;

/**
 * {@link} https://www.geeksforgeeks.org/jvm-shutdown-hook-java/
 * {@link} http://luizricardo.org/2013/08/construindo-objetos-de-forma-inteligente-builder-pattern-e-fluent-interfaces/
 * 
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

		
//		File file = new File("anelar-dir.bmp");
		
		
		out.println(System.getProperty("os.name"));
		out.println(System.getProperty("os.arch"));
		
//		Path path  = 
		
		out.println();
		
		File file = new File("anelar-esq.wsq");
		
		InputStream inputStream = new FileInputStream(file);
		
		byte[] teste = IOUtils.toByteArray(inputStream);
		
		String contentType = new Tika().detect(teste);
		
		System.out.println(contentType);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(teste);
		
		BufferedImage bufferedImage = ImageIO.read(bais);
		
		out.println(bufferedImage.getHeight());
		
		out.print(bufferedImage.getWidth());
		
		
	}

}
