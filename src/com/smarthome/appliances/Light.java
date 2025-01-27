package com.smarthome.appliances;

import com.smarthome.validator.SmartHomeValidator;
import java.util.Scanner;

//Light Class
public class Light extends Appliance {

	@Override
	public void getStatus() {
		System.out.println(getClass().getSimpleName() + " is already " + (isOn ? "ON" : "OFF") + ".");
	}

	@Override
	public void control(Scanner scanner) {
		System.out.println("Control Light: 1. ON, 0. OFF");
		// Validate the input
		if (SmartHomeValidator.validateIntegerInput(scanner)) {
			int intChoice = scanner.nextInt();
			if (SmartHomeValidator.validateRangeInput(intChoice, 0, 1)) {
				if ((isOn && intChoice == 1) || (!isOn && intChoice == 0)) {
					getStatus();
				} else {
					if (intChoice == 1) {
						turnOn();
					} else if (intChoice == 0) {
						turnOff();
					}
				}
			}
		}
	}

}
