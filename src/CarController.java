import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
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
		CarController cc = new CarController();

		// Start a new view and send a reference of self
		cc.frame = new CarView("CarSim 1.0", cc);



		// Start the timer
		cc.timer.start();
	}

	/* Each step the TimerListener moves all the cars in the list and tells the
	 * view to update its images. Change this method to your needs.
	 * */
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
				Vehicle car = vehicleGraphic.getCar();
				if (
						(car.getX() + vehicleGraphic.getImage().getHeight() >= frame.drawPanel.getWidth() && car.getDirection() == Direction.EAST) ||
						(car.getX() <= 0 && car.getDirection() == Direction.WEST) ||
						(car.getY() + vehicleGraphic.getImage().getHeight() >= frame.drawPanel.getHeight() && car.getDirection() == Direction.NORTH) ||
						(car.getY() <= 0 && car.getDirection() == Direction.SOUTH)
				) {
					car.turnAround();
				}

				car.move();
				frame.drawPanel.repaint();
			}
		}
	}

	// Calls the gas method for each car once
	void gas(int amount) {
		double gas = ((double) amount) / 100;
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			vehicleGraphic.getCar().gas(gas);
		}
	}

	void brake(int amount) {
		double brake = ((double) amount) / 100;
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			vehicleGraphic.getCar().brake(brake);
		}
	}

	void startEngine() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			vehicleGraphic.getCar().startEngine();
		}
	}

	void stopEngine() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			vehicleGraphic.getCar().stopEngine();
		}
	}

	void turboOn() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			Vehicle car = vehicleGraphic.getCar();
			if (car instanceof Turbo) {
				((Turbo) car).setTurboOn();
			}
		}
	}

	void turboOff() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			Vehicle car = vehicleGraphic.getCar();
			if (car instanceof Turbo) {
				((Turbo) car).setTurboOff();
			}
		}
	}

	void liftBed() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			Vehicle car = vehicleGraphic.getCar();
			if (car instanceof Scania) {
				Flatbed flatbed = ((Scania) car).getFlatbed();
				flatbed.changeTilt(flatbed.maxTilt);
			}
		}
	}

	void lowerBed() {
		for (VehicleGraphic vehicleGraphic : frame.drawPanel.getVehicleGraphics()) {
			Vehicle car = vehicleGraphic.getCar();
			if (car instanceof Scania) {
				Flatbed flatbed = ((Scania) car).getFlatbed();
				flatbed.changeTilt(flatbed.minTilt);
			}
		}
	}
}
