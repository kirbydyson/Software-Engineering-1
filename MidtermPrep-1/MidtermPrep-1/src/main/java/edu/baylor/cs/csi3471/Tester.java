/*
 * Author: Kirby Dyson
 * Course: CSI 3471
 * Assignment: Lab 5
 * File: Tester.java
 * Description: Your brief description
 */

package edu.baylor.cs.csi3471;

import java.io.*;
import java.util.*;

public class Tester {

	private static final int FILE_NAME = 1;
	private static final int OPTION = 0;

	private static int readOption(String[] args) {
		Integer option = null;
		if (args.length != 2) {
			System.err.println("USAGE: java Tester <1-4> <filename>");
			System.exit(1);
		} else {
			try {
				option = Integer.parseInt(args[OPTION]);
			} catch (NumberFormatException e) {
				System.err.println("call as java Tester <1-4> <filename>");
				System.exit(1);
			}
		}
		return option;
	}

	public static Collection<Make> populateSet(Collection<Make> set, String[] line) {
		String makeName = line[6];
		ModelSettings newModel = new ModelSettings(line);

		for (Make make : set) {
			if (make.getMakeName().equalsIgnoreCase(makeName)) {
				make.getModelSettingSet().add(newModel);
				return set;
			}
		}

		Make newMake = new Make(line);
		newMake.getModelSettingSet().add(newModel);
		set.add(newMake);
		return set;
	}
	private static Set<Make> loadCSV(String file) throws FileNotFoundException {
		BufferedReader reader = null;
		Set<Make> makes = new HashSet<>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			reader.readLine();
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] split = line.split(",");

				if (Arrays.stream(split).anyMatch(String::isEmpty)) {
					continue;
				}

				populateSet(makes, split);
			}
		} catch (IOException e) {
			String hint = "";
			try {
				hint = "Current dir is: " + new File(".").getCanonicalPath();
			} catch (Exception local) {
				hint = local.getLocalizedMessage();
			}
			throw new FileNotFoundException(e.getLocalizedMessage() + "\n" + hint);

		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.err.println(e.getLocalizedMessage());
				}
			}
		}
		return makes;
	}

	public static void main(String[] args) {
		int option = readOption(args);

		Set<Make> makes = null;
		try {
			makes = loadCSV(args[FILE_NAME]);

		} catch (FileNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			System.exit(1);
		}
		switch (option) {
			case 1:
				optionOne(makes);
				break;
			case 2:
				// For Practicum
				break;

			case 3:
				// For Practicum
				break;

			case 4:
				// For Practicum
				break;
			default:
				System.err.println("call as java Tester <1-4> <filename>");
				System.exit(1);
				break;
		}

	}

	public static void optionOne(Collection<Make> makes) {
		List<Make> sortedMakes = new ArrayList<>(makes);
		sortedMakes.sort(Comparator.comparing(Make::getMakeName));

		System.out.println("Total Number of Makes: " + sortedMakes.size());
		System.out.println("===============");

		for (Make make : sortedMakes) {
			System.out.println(make.getMakeName() + " has " + make.getModelSettingSet().size() + " models");
		}
		System.out.println("===============");
		for (Make make : sortedMakes) {
			System.out.println(make.toString());
		}

	}
	public static Comparator<Make> sort() {
		return (make1, make2) -> make1.getMakeName().compareToIgnoreCase(make2.getMakeName());
	}
}
