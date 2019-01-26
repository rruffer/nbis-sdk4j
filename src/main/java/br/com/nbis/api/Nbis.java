package br.com.nbis.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.api.bozorth3.BOZORTH3;
import br.com.nbis.api.mindtct.MINDTCT;
import br.com.nbis.api.nfiq.NFIQ;
import br.com.nbis.api.wsq.WSQ;

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
	
	public static void mindtct(String img) {
		MINDTCT.getInstance().template(img);
	}
	
	public static int bozorth3(String img1, String img2) {
		return BOZORTH3.getInstance().merge(img1, img2);
	}
	
}