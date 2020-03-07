import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CsvToJson {
    public static void main(String ... args) throws IOException {
        File input = new File("C://dev//events.csv");
        File output = new File("C://dev//events.json");
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
        }

    }

}
