package graphics;

import models.Saab95;
import models.Scania;
import models.Volvo240;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

	private List<VehicleGraphic> vehicleGraphics = new ArrayList<>();

	public List<VehicleGraphic> getVehicleGraphics() {
		return vehicleGraphics;
	}

	// Initializes the panel and reads the images
	public DrawPanel(int x, int y) {
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(x, y));
		this.setBackground(Color.green);

		vehicleGraphics.add(new VehicleGraphic(new Volvo240(0, 0), "pics/Volvo240.jpg"));
		vehicleGraphics.add(new VehicleGraphic(new Saab95(0, 100), "pics/Saab95.jpg"));
		vehicleGraphics.add(new VehicleGraphic(new Scania(0, 200), "pics/Scania.jpg"));
	}

	// This method is called each time the panel updates/refreshes/repaints itself
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (VehicleGraphic vehicle : vehicleGraphics) {
		    g.drawImage(vehicle.getImage(), vehicle.getX(), vehicle.getY(), null);
        }
	}
}
