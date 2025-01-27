package com.smarthome.appliances;

import java.util.Scanner;

import com.smarthome.enums.FanSpeed;
import com.smarthome.validator.SmartHomeValidator;

//Fan Class
public class Fan extends Appliance {
	private FanSpeed speed; // 0 = OFF, 1 = LOW, 2 = HIGH

	public Fan() {
		this.speed = FanSpeed.OFF;
	}

	@Override
	public void getStatus() {
		System.out.println(getClass().getSimpleName() + " speed is already " + this.speed + ".");
	}

	@Override
	public void control(Scanner scanner) {
		System.out.println("Control Fan Speed: 0. OFF, 1. LOW, 2. HIGH");

		// Validate the input
		if (SmartHomeValidator.validateIntegerInput(scanner)) {
			int intChoice = scanner.nextInt();
			if (SmartHomeValidator.validateRangeInput(intChoice, 0, 2)) {
				if (speed == FanSpeed.values()[intChoice]) {
					getStatus();
				} else {
					speed = FanSpeed.values()[intChoice];
					switch (intChoice) {
					case 1: // LOW
					case 2: // High
						speed = FanSpeed.values()[intChoice];
						if (!isOn) {
							turnOn();
						}
						System.out.println("Fan speed set to  " + speed + ".");
						break;
					case 0:
						speed = FanSpeed.values()[intChoice];
						turnOff();
						break;
					}
				}
			}
		}

	}
}
