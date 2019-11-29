package graphics;

import models.Vehicle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * Represents a graphical interpretation of a vehicle.
 * @autor Albin Landgren
 * @version 1.0.0
 * @since 1.0.0
 */
public class VehicleGraphic {
	private BufferedImage image;
	private final Vehicle vehicle;

	public VehicleGraphic(Vehicle vehicle, String image) {
		this.vehicle = vehicle;
		try {
			this.image = ImageIO.read(DrawPanel.class.getResourceAsStream(String.format("../pics/%s", image)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @return the x attribute of the corresponding vehicle
	 */
	public int getX() {
		return (int) vehicle.getX();
	}

	/**
	 *
	 * @return the y attribute of the corresponding vehicle
	 */
	public int getY() {
		return (int) vehicle.getY();
	}

	/**
	 *
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 *
	 * @return the corresponding vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}
}
