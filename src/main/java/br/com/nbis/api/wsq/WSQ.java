package br.com.nbis.api.wsq;

import java.awt.image.BufferedImage;
import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WSQ {

	private final Logger log = LogManager.getLogger(getClass());
	private final EncoderWSQ encoderWSQ = new EncoderWSQ();
	private final DecoderWSQ decoderWSQ = new DecoderWSQ();
	
	private static WSQ instance;

	private WSQ() {

	}

	public static synchronized WSQ getInstance() {
		if (instance == null) {
			instance = new WSQ();
		}

		return instance;
	}


	public void encoder(String img) {
		
		encoderWSQ.encoder(img);
		
	}
	
	public void encoder(File img) {
		// TODO Auto-generated method stub
		encoderWSQ.encoder(img);
		
	}
	
	public void encoder(byte[] img) {
		// TODO Auto-generated method stub
		encoderWSQ.encoder(img);
		
	}
	
	/*
	 * public void encoder(BufferedImage img) { // TODO Auto-generated method stub
	 * encoderWSQ.encoder(img);
	 * 
	 * }
	 */

	public void decoder(String string) {
		decoderWSQ.decoder(string);
		
	}


}