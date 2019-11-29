package graphics;

import models.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class VehicleController {
	// member fields:

	// The delay (ms) corresponds to 20 updates a sec (hz)
	private final int delay = 50;
	// The timer is started with an listener (see below) that executes the statements
	// each step between delays.
	private Timer timer = new Timer(delay, new TimerListener());

	// The frame that represents this instance View of the MVC pattern
	CarView frame;

	//methods:

	public static void main(String[] args) {
		// Instance of this class
		VehicleController vc = new VehicleController();

		// Start a new view and send a reference of self
		vc.frame = new CarView("CarSim 1.0", vc);

		// Start the timer
		vc.timer.start();
	}

	/* Each step the TimerListener moves all the cars in the list and tells the
	 * view to update its images. Change this method to your needs.
	 * */
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
				Vehicle vehicle = vehicleGraphic.getVehicle();
				if (
						(vehicle.getX() + vehicleGraphic.getImage().getHeight() >= frame.drawPanel.getWidth() && vehicle.getDirection() == Direction.EAST) ||
						(vehicle.getX() <= 0 && vehicle.getDirection() == Direction.WEST) ||
						(vehicle.getY() + vehicleGraphic.getImage().getHeight() >= frame.drawPanel.getHeight() && vehicle.getDirection() == Direction.NORTH) ||
						(vehicle.getY() <= 0 && vehicle.getDirection() == Direction.SOUTH)
				) {
					vehicle.turnAround();
				}

				vehicle.move();
				frame.drawPanel.repaint();
			}
		}
	}

	/**
	 * Calls the gas method for each vehicle with the supplied amount
	 * @param amount
	 */
	void gas(int amount) {
		double gas = ((double) amount) / 100;
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			vehicleGraphic.getVehicle().gas(gas);
		}
	}

	/**
	 * Calls the brake method for each vehicle with the supplied amount
	 * @param amount
	 */
	void brake(int amount) {
		double brake = ((double) amount) / 100;
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			vehicleGraphic.getVehicle().brake(brake);
		}
	}

	/**
	 * Starts all vehicles
	 */
	void startEngine() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			vehicleGraphic.getVehicle().startEngine();
		}
	}

	/**
	 * Stops all vehicles
	 */
	void stopEngine() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			vehicleGraphic.getVehicle().stopEngine();
		}
	}

	/**
	 * Turns on turbo for all applicable vehicles
	 */
	void turboOn() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			Vehicle vehicle = vehicleGraphic.getVehicle();
			if (vehicle instanceof Turbo) {
				((Turbo) vehicle).setTurboOn();
			}
		}
	}

	/**
	 * Turns off turbo for all applicable vehicles
	 */
	void turboOff() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			Vehicle vehicle = vehicleGraphic.getVehicle();
			if (vehicle instanceof Turbo) {
				((Turbo) vehicle).setTurboOff();
			}
		}
	}

	/**
	 * Lifts the flatbed for all applicable vehicles
	 */
	void liftBed() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			Vehicle vehicle = vehicleGraphic.getVehicle();
			if (vehicle instanceof Scania) {
				Flatbed flatbed = ((Scania) vehicle).getFlatbed();
				flatbed.changeTilt(flatbed.maxTilt);
			}
		}
	}

	/**
	 * Lowers the flatbed for all applicable vehicles
	 */
	void lowerBed() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			Vehicle vehicle = vehicleGraphic.getVehicle();
			if (vehicle instanceof Scania) {
				Flatbed flatbed = ((Scania) vehicle).getFlatbed();
				flatbed.changeTilt(flatbed.minTilt);
			}
		}
	}
}
