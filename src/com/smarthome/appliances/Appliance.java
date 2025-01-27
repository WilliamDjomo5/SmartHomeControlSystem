package com.smarthome.appliances;

import java.util.Scanner;

//Abstract Appliance Class
public abstract class Appliance {

	protected boolean isOn;

	public Appliance() {
		this.isOn = false;
	}

	public abstract void control(Scanner scanner);

	public void turnOff() {
		this.isOn = false;
		System.out.println(getClass().getSimpleName() + " is now OFF.");
	}

	public void turnOn() {
		this.isOn = true;
		System.out.println(getClass().getSimpleName() + " is now ON.");
	}

	/**
	 * Retrieves the current status of the appliance.
	 * print a string indicating whether the status/state of the appliance
	 */

	public abstract void getStatus();

}
