package networking;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Webimage {
	public String path;
	public BufferedImage source;
	public Webimage(String source, String path) {
		File file = new File(source); 
		try {
			this.source = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		};
		this.path = path;
	}
	public BufferedImage load() {
		return source;
	}
}