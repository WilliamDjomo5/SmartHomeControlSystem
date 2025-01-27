package com.smarthome.appliances;

import java.util.Scanner;

import com.smarthome.enums.AirConditionerMode;
import com.smarthome.validator.SmartHomeValidator;

//AirConditioner Class
public class AirConditioner extends Appliance {
	private AirConditionerMode mode; // Modes: OFF, COOL, HEAT

	public AirConditioner() {
		this.mode = AirConditionerMode.OFF;
	}

	@Override
	public void getStatus() {
		System.out.println(getClass().getSimpleName() + " mode is already " + this.mode + ".");
	}

	@Override
	public void control(Scanner scanner) {
		System.out.println("Control Air Conditioner Mode: 0. OFF, 1. COOL, 2. HEAT");

		// Validate the input
		if (SmartHomeValidator.validateIntegerInput(scanner)) {
			int intChoice = scanner.nextInt();
			if (SmartHomeValidator.validateRangeInput(intChoice, 0, 2)) {
				if (mode == AirConditionerMode.values()[intChoice]) {
					getStatus();
				} else {
					switch (intChoice) {
					case 1: // COOL
					case 2: // HEAT
						mode = AirConditionerMode.values()[intChoice];
						if (!isOn) {
							turnOn();
						}
						System.out.println("Air Conditioner set to " + mode + " mode.");
						break;
					case 0:
						mode = AirConditionerMode.OFF;
						turnOff();
						break;
					}
				}
			}
		}
	}
}
