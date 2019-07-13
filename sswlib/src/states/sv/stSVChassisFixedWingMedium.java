package states.sv;

import java.util.LinkedList;

import states.ifSVchassis;

public class stSVChassisFixedWingMedium implements ifSVchassis {

	public double getBCV() {
		return 0.1;
	}

	public double getBEV() {
		return 0.01;
	}

	public double getMaximumTonnage() {
		return 100;
	}

	public String getMinimumTR() {
		return "B";
	}

	public double getMinimumTonnage() {
		return 5;
	}

	public String getMotiveType() {
		return "Fixed-Wing";
	}

	public String getSize() {
		return "Medium";
	}
	
	public LinkedList<String> getLocations() {
		LinkedList<String> tempLocations = new LinkedList<String>();
		tempLocations.add("Nose");
		tempLocations.add("Left Wing");
		tempLocations.add("Right Wing");
		tempLocations.add("Aft");
		return tempLocations;
	}

}
