import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VehicleGraphic {
	private BufferedImage image;
	private Vehicle car;

	public VehicleGraphic(Vehicle car, String imagePath) {
		this.car = car;
		try {
			this.image = ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public Vehicle getCar() {
		return car;
	}
}
