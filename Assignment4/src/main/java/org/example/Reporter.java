package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Reporter {
    private final String name, city, state, url;

    public Reporter(){
        name = "";
        city = "";
        state = "";
        url = "";
    }
    public Reporter(String name, String city, String state, String url) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getUrl() {
        return url;
    }

    public static void main(String[] args) throws FileNotFoundException {

        if (args == null || args.length != 2) {
            System.out.println("syntax is Reporter <file path> <report type 1-3>");
            System.exit(0);
        }

        Scanner scanner = new Scanner(new File(args[0]));

        System.out.println("---");
        List<Reporter> institutions = new ArrayList<>();
        int reportType = Integer.parseInt(args[1]);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] columns = line.split(",");

            String name = columns[1];
            String city = columns[4];
            String state = columns[5];
            String url = columns[6];

            if(reportType == 1 && name.toLowerCase().contains("tech")) continue;
            institutions.add(new Reporter(name, city, state, url));
        }
        scanner.close();

        switch(reportType){
            case 1:
                report1(institutions);
                break;
            case 2:
                report2(institutions);
                break;
            case 3:
                report3(institutions);
                break;
            default:
                System.out.println("ERROR: Invalid report type");
                break;
        }
    }

    public static void report1(List<Reporter> institutions){
        institutions.stream().sorted(Comparator.comparing(Reporter::getCity))
                .forEach(i -> System.out.println(i.getName() + i.getCity() + i.getState() + i.getUrl()));
    }
    public static void report2(List<Reporter> institutions) {
        Map<String, Long> cityCount = institutions.stream()
                .collect(Collectors.groupingBy(Reporter::getCity, Collectors.counting()));

        cityCount.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + e.getValue()));
    }
    public static void report3(List<Reporter> institutions) {
        Map<String, Long> stateCount = institutions.stream()
                .collect(Collectors.groupingBy(Reporter::getState, Collectors.counting()));

        stateCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + e.getValue()));
    }
}
