package br.nbis.com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.jnbis.internal.WsqDecoder;

import br.nbis.com.encoder.Bitmap;
import br.nbis.com.encoder.WSQEncoder;

/**
 * @link https://crestaniblog.wordpress.com/2013/01/10/conversao-de-imagem-para-o-formato-wsq/
 * @author rodolfo.ruffer
 *
 */
public class TesteWSQ {

	public static void main(String[] args) throws Exception {
		
		//define o arquivo original e o arquivo de saida
		BufferedImage imgBuffer = ImageIO.read(new File("digital.png"));
		OutputStream outputStream = new FileOutputStream("imagem.wsq");

		//recuperar o buffer em array de byte
		byte[] pixels = (byte[])imgBuffer.getRaster().getDataElements(0, 0, imgBuffer.getWidth(), imgBuffer.getHeight(), null);

		//int depth = 24
		//int ppi = 500
		//int lossyflag = 1

		Bitmap bitmap = new Bitmap(pixels, imgBuffer.getWidth(), imgBuffer.getHeight(), (int) Math.round(500), 8, 1);

		//codifica em wsq
		WSQEncoder.encode(outputStream, bitmap, 1.5, "");
		
		byte [] img = new byte[10000];
		
		outputStream.write(img);
		
		System.out.println(img);

		outputStream.close();

	}

}
