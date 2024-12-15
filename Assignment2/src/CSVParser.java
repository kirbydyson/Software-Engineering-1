import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CSVParser {
    private static String byeQuotes(String val){
        return val.replaceAll("\"", "").trim();
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("---");

        if(scan.hasNextLine()){
            scan.nextLine();
        }

        long workoutTime = 0;
        long duration;
        int highestWeight = 0;
        int highestVitaminC = 0;
        int people = 0;
        int liftedWeight;
        int vitaminC;
        double totalWeight = 0;
        double personalWeight;

        String longestWorkout = "";
        String highWeight = "";
        String highVitaminC = "";

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println(line);
            System.out.println("---");
            String[] tokens = line.split("\t");

            if(tokens.length != 8){
                continue;
            }
            for(int i = 0; i < tokens.length; i++){
                tokens[i] = byeQuotes(tokens[i]);
            }

            String name = tokens[0];

            try{
                liftedWeight = Integer.parseInt(tokens[2]);
                if(liftedWeight > highestWeight){
                    highestWeight = liftedWeight;
                    highWeight = name;
                }

                String[] consumption = tokens[7].split("/");
                vitaminC = Integer.parseInt(consumption[1]);
                if(vitaminC > highestVitaminC){
                    highestVitaminC = vitaminC;
                    highVitaminC = name;
                }

                Date startDate = sdf.parse(tokens[5]);
                Date endDate = sdf.parse(tokens[6]);
                duration = (endDate.getTime() - startDate.getTime()) / 60000;
                if(duration > workoutTime){
                    workoutTime = duration;
                    longestWorkout = name;
                }

                personalWeight = Double.parseDouble(tokens[3]);
                totalWeight += liftedWeight;
                people++;
            }
            catch(NumberFormatException | ParseException e){
                System.err.println("Error parsing line: " + line);
                System.err.println("Exception: " + e.getMessage());
            }
        }

        double avgWeight = 0;
        if(people > 0){
            avgWeight = totalWeight / people;
        }

        System.out.println("Longest Workout Duration: " + longestWorkout);
        System.out.println("Highest Lifted Weight: " + highWeight);
        System.out.println("Highest Vitamin C Consumption: " + highVitaminC);
        System.out.println("Total People: " + people);
        System.out.println("Average Lifted Weight: " + avgWeight);

        scan.close();
    }
}
