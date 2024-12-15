/*
 * Author: Kirby Dyson
 * Course: CSI 3471
 * Assignment: Lab 5
 * File: ModelSettings.java
 * Description: Your brief description
 */

package edu.baylor.cs.csi3471;

public class ModelSettings {

	public static class MPG {
		private final int cityMPG, highwayMPG, combMPG;

		public MPG(int cityMPG, int highwayMPG, int combMPG) {
			this.cityMPG = cityMPG;
			this.highwayMPG = highwayMPG;
			this.combMPG = combMPG;
		}

		@Override
		public String toString() {
			return "MPG[ " + "City: " + cityMPG + ", Highway: " + highwayMPG +
					", Combined: " + combMPG + " ]";
		}
	}

	private MPG mpg = null;
	int year;
	String model, trans;
	double volume;
	int cityMPG, highwayMPG, combMPG;

	@Override
	public int hashCode() {
		return model != null ? model.hashCode(): 0;
	}

	@Override
	public String toString() {
		return "ModelSettings [Model: " + model + ", Year: " + year +
				", Transmission: " + trans + ", Volume: " + volume + ", " + mpg + "]";
	}

	public ModelSettings(String[] line) {
		super();
		cityMPG = Integer.parseInt(line[0]);
		combMPG = Integer.parseInt(line[1]);
		highwayMPG = Integer.parseInt(line[5]);
		volume = Double.parseDouble(line[3]);
		model = line[7];
		trans = line[8];
		year = Integer.parseInt(line[10]);
		this.mpg = new MPG(cityMPG, highwayMPG, combMPG);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null || getClass() != obj.getClass()){
			return false;
		}
		ModelSettings mod = (ModelSettings) obj;
		return model.equals(mod.model) && year == mod.year && trans.equals(mod.trans)
				&& volume == mod.volume;
	}
}
