package com.smarthome;

import com.smarthome.appliances.*;
import com.smarthome.utilities.UpdateScheduler;
import com.smarthome.validator.SmartHomeValidator;

import java.util.Scanner;

//SmartHomeRunner Class main
public class SmartHomeRunner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Appliance light = new Light();
		Appliance fan = new Fan();
		Appliance airConditioner = new AirConditioner();

		// schedule the annual update
		  UpdateScheduler.scheduleAnnualUpdate(light, fan, airConditioner);

		System.out.println("Welcome to your Smart Home. Control your appliances easily.");
		System.out.println("Please configure your appliances:");

		while (true) {
			System.out.println("Select an appliance to control:");
			System.out.println("1. Light\n2. Fan\n3. Air Conditioner\n4. Exit");

			if (SmartHomeValidator.validateIntegerInput(scanner)) {
				int intChoice = scanner.nextInt();
				if (!SmartHomeValidator.validateRangeInput(intChoice, 1, 4)) {
					continue;
				}
				switch (intChoice) {
				case 1:
					light.control(scanner);
					break;
				case 2:
					fan.control(scanner);
					break;
				case 3:
					airConditioner.control(scanner);
					break;
				case 4:
					System.out.println("Exiting the Smart Home Control System. Goodbye!");
					scanner.close();
					return;
				}
			}
		}
	}
}