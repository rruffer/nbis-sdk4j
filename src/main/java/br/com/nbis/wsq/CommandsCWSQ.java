package br.com.nbis.wsq;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandsCWSQ implements Command{
	
	private final Logger log = LogManager.getLogger(getClass());

	@Override
	public String[] command(File... file) {
		String[] commands = null;
		
		File fileExec = file[0];
		File filePath = file[1];
		
		try {
			BufferedImage image = ImageIO.read(filePath);
			String dimencoesImg = String.format("%d,%d,%d,%d", image.getWidth(), image.getHeight(), image.getColorModel().getPixelSize(), 500);
			commands = Stream.of(fileExec.getAbsolutePath(), ".75", "wsq", filePath.getAbsolutePath(), "-r", dimencoesImg).toArray(String[]::new);
		} catch (IOException e) {
			log.error("Erro ao criar comando cwsq", e);
		}
		
		return commands;
	}

}
