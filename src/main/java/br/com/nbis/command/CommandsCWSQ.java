package br.com.nbis.command;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.nbis.exeption.NbisException;

public class CommandsCWSQ implements Command{
	
	private final Logger log = LogManager.getLogger(getClass());

	@Override
	public String[] command(File... file) throws NbisException {
		String[] commands = null;
		
		File fileExec = file[0];
		File filePath = file[1];
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(filePath);
		} catch (IOException e) {
			log.error("CommandsCWSQ: ", e);
			throw new NbisException("Erro ao converter imagem: " + e.getMessage());
		}
		String dimencoesImg = String.format("%d,%d,%d,%d", image.getWidth(), image.getHeight(), image.getColorModel().getPixelSize(), 500);
		//linha de comando cwsq.exe .75 wsq digital.png -r 800,750,8,500
		commands = Stream.of(fileExec.getAbsolutePath(), ".75", "wsq", filePath.getAbsolutePath(), "-r", dimencoesImg).toArray(String[]::new);
		
		return commands;
	}

}
