package graphics;

import models.Vehicle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VehicleGraphic {
	private BufferedImage image;
	private Vehicle vehicle;

	public VehicleGraphic(Vehicle vehicle, String imagePath) {
		this.vehicle = vehicle;
		try {
			this.image = ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getX() {
		return (int) vehicle.getX();
	}

	public int getY() {
		return (int) vehicle.getY();
	}

	public BufferedImage getImage() {
		return image;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
}
