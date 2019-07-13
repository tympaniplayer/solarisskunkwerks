package states.sv;

import java.util.LinkedList;

import states.ifSVchassis;

public class stSVChassisVTOLLarge implements ifSVchassis {

	public double getBCV() {
		return 0.3;
	}

	public double getBEV() {
		return 0.004;
	}

	public double getMaximumTonnage() {
		return 60;
	}

	public String getMinimumTR() {
		return "C";
	}

	public double getMinimumTonnage() {
		return 30.5;
	}

	public String getMotiveType() {
		return "VTOL";
	}

	public String getSize() {
		return "Large";
	}
	
	public LinkedList<String> getLocations() {
		LinkedList<String> tempLocations = new LinkedList<String>();
		tempLocations.add("Front");
		tempLocations.add("Left");
		tempLocations.add("Right");
		tempLocations.add("Rear");
		tempLocations.add("Rotor");
		tempLocations.add("Chin Turret");
		return tempLocations;
	}

}
