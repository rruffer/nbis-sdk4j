package br.com.nbis;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

import br.com.nbis.util.UtilLoader;
import br.com.nbis.util.UtilLoaderExecPlatform;

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
		
	/*	File file = new File("anelar-esq.wsq");
		
		InputStream inputStream = new FileInputStream(file);
		
		byte[] teste = IOUtils.toByteArray(inputStream);
		
		String contentType = new Tika().detect(teste);
		
		System.out.println(contentType);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(teste);
		
		BufferedImage bufferedImage = ImageIO.read(bais);
		
		out.println(bufferedImage.getHeight());
		
		out.print(bufferedImage.getWidth());*/
		
		String teste = "file.txt";
		
//		System.out.println(teste.substring(teste.lastIndexOf("."))); 
		
		System.out.println(FilenameUtils.getExtension(teste));
		
		String pathOS = UtilLoaderExecPlatform.getPathOS();
		
		UtilLoader.setFileDll(pathOS, "Nfiq2Api.dll");
		
		
	}

}
