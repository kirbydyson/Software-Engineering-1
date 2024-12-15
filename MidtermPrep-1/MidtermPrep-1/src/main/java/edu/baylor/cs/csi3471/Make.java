/*
 * Author: Kirby Dyson
 * Course: CSI 3471
 * Assignment: Lab 5
 * File: Make.java
 * Description: Your brief description
 */

package edu.baylor.cs.csi3471;

import java.util.*;

public class Make {
	private Set<ModelSettings> modelSettingSet;
	private final String makeName;
	private static int id = 1;


	public Set<ModelSettings> getModelSettingSet() {
		return modelSettingSet;
	}

	public void setModelSettingSet(Set<ModelSettings> modelSettingSet) {
		this.modelSettingSet = modelSettingSet;
	}

	@Override
	public int hashCode() {
		return modelSettingSet != null ? modelSettingSet.hashCode(): 0;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(String.format("ID: %s, Make Name: %s\n", id, makeName));
		modelSettingSet.stream()
				.sorted(Comparator.comparing((ModelSettings modSet) -> modSet.year)
						.thenComparing(modSet -> modSet.trans)
						.thenComparing(modSet -> modSet.volume))
				.forEach(modSet -> string.append(modSet.toString()).append("\n"));

		return string.toString();
	}

	public Make(String[] line) {
		super();
		modelSettingSet = new HashSet<>();
		modelSettingSet.add(new ModelSettings(line));
		makeName = line[6];
		id++;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null || getClass() != obj.getClass()){
			return false;
		}
		Make make = (Make)obj;
		return this.makeName.equals(make.makeName) ;
	}

	public String getMakeName() {
		return makeName;
	}
}