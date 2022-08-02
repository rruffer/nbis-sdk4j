package br.com.nbis.api;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.api.bozorth3.BOZORTH3;
import br.com.nbis.api.mindtct.MINDTCT;
import br.com.nbis.api.nfiq.NFIQ;
import br.com.nbis.api.nfiq.NFIQ2;
import br.com.nbis.api.wsq.WSQ;
import br.com.nbis.exeption.NbisException;
import br.com.nbis.util.UtilConstants;
import br.com.nbis.util.UtilFile;

/**
 * @link http://www.hjort.co/2015/12/evaluating-nbis-using-fvc2004-databases-part1.html
 * @link https://stackoverflow.com/questions/15464111/run-cmd-commands-through-java
 * @link https://coderanch.com/t/480489/java/ImageMagick-Java-Runtime-Exec
 * @link https://stackoverflow.com/questions/18010604/running-java-runtime-exec-for-multiple-process
 * @link https://www.developer.com/java/data/understanding-java-process-and-java-processbuilder.html
 * 
 * @author rodolfo.ruffer
 *
 */
public class Nbis {

	private final Logger log = LogManager.getLogger(getClass());

	private Nbis() {

	}

	public static WSQ wsq() {
		return WSQ.getInstance();
	}

	public static int nfiq(String img) {
		return NFIQ.getInstance().quality(img);
	}

	public static int nfiq(File file) {
		return NFIQ.getInstance().quality(file);
	}
	
	public static int nfiq(byte[] file) throws IOException, NbisException {
		return NFIQ.getInstance().quality(file);
	}

	public static int nfiq2(String img) {
		return NFIQ2.getInstance().quality(img);
	}
	
	public static int nfiq2(File file) {
		return NFIQ2.getInstance().quality(file);
	}
	
	public static int nfiq2(byte[] file) throws IOException, NbisException {
		return NFIQ2.getInstance().quality(file);
	}

	public static MINDTCT mindtct(String img) throws IOException {
		return new MINDTCT(img);
	}

	public static MINDTCT mindtct(File img) throws IOException {
		return new MINDTCT(img);
	}

	public static MINDTCT mindtct(byte[] img) throws IOException, NbisException {
		return new MINDTCT(img);
	}

	public static int bozorth3(String img1, String img2) {
		return BOZORTH3.getInstance().merge(img1, img2);
	}

	public static int bozorth3(File img1, File img2) {
		return BOZORTH3.getInstance().merge(img1, img2);
	}

	public static int bozorth3(byte[] img1, byte[] img2) throws IOException, NbisException {
		return BOZORTH3.getInstance().merge(img1, img2);
	}

	public static void close() {
		try {
			UtilFile.deletarDiretorios(UtilConstants.TEMP_DIR_NBIS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
