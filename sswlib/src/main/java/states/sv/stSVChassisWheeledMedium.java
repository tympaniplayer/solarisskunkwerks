package states.sv;

import java.util.LinkedList;

import states.ifSVchassis;

public class stSVChassisWheeledMedium implements ifSVchassis {

	public double getBCV() {
		return 0.15;
	}

	public double getBEV() {
		return 0.0075;
	}

	public double getMaximumTonnage() {
		return 80;
	}

	public String getMinimumTR() {
		return "A";
	}

	public double getMinimumTonnage() {
		return 5;
	}

	public String getMotiveType() {
		return "Wheeled";
	}

	public String getSize() {
		return "Medium";
	}
	
	public LinkedList<String> getLocations() {
		LinkedList<String> tempLocations = new LinkedList<String>();
		tempLocations.add("Front");
		tempLocations.add("Left");
		tempLocations.add("Right");
		tempLocations.add("Rear");
		tempLocations.add("Front Turret");
		tempLocations.add("Rear Turret");
		return tempLocations;
	}

}
