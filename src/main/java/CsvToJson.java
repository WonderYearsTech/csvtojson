import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CsvToJson {
    public static void main(String ... args) {
        boolean toContinue = true;
        Scanner scanner = new Scanner(System.in);
        try {
            while (toContinue) {
                System.out.println("Type in events.csv file directory location Eg: C:\\cvs and press ENTER");
                String csvLocation = scanner.nextLine();
                toContinue = false;
                String csvDir = FilenameUtils.normalize(FilenameUtils.separatorsToSystem(csvLocation));
                if (!Files.isDirectory(Paths.get(csvDir))) {
                    System.out.println("events.csv file does not exist at " + csvDir + "\n");
                    System.out.println("Please make sure events.csv file is placed at " + csvDir + " and try again");
                    return;
                } else {
                    File input = new File(csvDir + File.separator + "events.csv");
                    File output = new File(csvDir + File.separator + "events.json");
                    Pattern pattern = Pattern.compile(",");
                    try (BufferedReader in = new BufferedReader(new FileReader(input));) {
                        List<Event> weeks = in
                                .lines()
                                .skip(1)
                                .map(line -> {
                                    String[] x = pattern.split(line);
                                    return new Event(x[0],x[1],x[2], x[0]+"-"+x[2]);
                                })
                                .collect(Collectors.toList());
                        ObjectMapper mapper = new ObjectMapper();
                        mapper.enable(SerializationFeature.INDENT_OUTPUT);
                        FileWriter fileWriter = new FileWriter(output);
                        mapper.writeValue(fileWriter, weeks);
                        System.out.println(output.toString() + " File is saved");
                    } catch (IOException e) {
                        System.out.println("events.csv file does not exist at " + csvDir + "\n");
                        System.out.println("Please make sure events.csv file is placed at " + csvDir + " and try again");
                    }
                }
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println("System.in closed; exiting");
        }
    }

}
