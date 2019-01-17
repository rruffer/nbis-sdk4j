package br.nbis.com;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import br.nbis.com.util.DLL_Setup;

/**
 * @link http://www.hjort.co/2015/12/evaluating-nbis-using-fvc2004-databases-part1.html
 * @author rodolfo.ruffer
 *
 */
public class TesteCWSQ {

	//linha de comando cwsq.exe .75 wsq digital.png -r 800,750,8,500
	public static void main(String[] args) throws Exception {

		File file = new DLL_Setup().getFile("/win-64/bin/cwsq.exe");

		File f = new File("digital.png");
		
		BufferedImage image = ImageIO.read(f);
		String dimencoesImg = String.format("%d,%d,%d,%d", image.getWidth(), image.getHeight(), image.getColorModel().getPixelSize(), 500);
		System.out.println(dimencoesImg);
		
		Runtime rt = Runtime.getRuntime();
		String[] commands = { file.getAbsolutePath(), ".75", "wsq", f.getAbsolutePath(), "-r", dimencoesImg};
		
		Process proc = rt.exec(commands);
		//proc.waitFor();
		
		OutputStream rsyncStdIn = proc.getOutputStream();
		
		BufferedImage array = ImageIO.read(proc.getInputStream());

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		// read the output from the command
		System.out.print("Here is the standard output of the command: ");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			System.out.println(getQualidade(s));
		}

		// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
		
		file.deleteOnExit();

	}

	private File getFile(String fileName) {

		File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

		return file;

	}
	
	private File getFile2(String fileName) {
		
		InputStream stream = getClass().getResourceAsStream("/" + fileName);
		File file = new File(System.getProperty("user.dir") + File.separator + "win-64" + File.separator + "cwsq.exe");
		try {
			FileUtils.copyInputStreamToFile(stream, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return file;
		
	}
	
	private File getFile3(String fileName) {
		
		InputStream stream = getClass().getResourceAsStream("/" + fileName);
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

	private static int getQualidade(String nfiq) {
		
		int num = Integer.parseInt(nfiq);
		
		switch (num) {
		case 1:
			return 100;
		case 2:
			return 80;
		case 3:
			return 60;
		case 4:
			return 40;
		case 5:
			return 20;
		default:
			return 0;
		}
	}
}
