package graphics;

import models.Vehicle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class VehicleGraphic {
	private BufferedImage image;
	private final Vehicle vehicle;

	public VehicleGraphic(Vehicle vehicle, String image) {
		this.vehicle = vehicle;
		try {
			System.out.println(String.format("../pics/%s", image));
			this.image = ImageIO.read(DrawPanel.class.getResourceAsStream(String.format("../pics/%s", image)));
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
