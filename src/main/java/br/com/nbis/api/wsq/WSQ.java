package br.com.nbis.api.wsq;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.exeption.NbisException;

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


	public EncoderWSQ encoder(String img) throws IOException {
		return new EncoderWSQ(img);
	}
	
	public EncoderWSQ encoder(File img) throws IOException {
		return new EncoderWSQ(img);
	}
	
	public EncoderWSQ encoder(byte[] img) throws IOException, NbisException {
		return new EncoderWSQ(img);
	}
	
	/*
	 * public void encoder(BufferedImage img) { // TODO Auto-generated method stub
	 * encoderWSQ.encoder(img);
	 * 
	 * }
	 */

	public DecoderWSQ decoder(String img) throws IOException {
		return new DecoderWSQ(img);
		
	}
	
	public DecoderWSQ decoder(File img) throws IOException {
		return new DecoderWSQ(img);
	}


}