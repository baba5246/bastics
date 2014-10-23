package bastics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Bastics class
 */
public class Bastics {

    private static final String PIPE = "|";

    public static Statistics computeBasicStatistics(String inputPath) throws IOException {

        StatisticsComputer sc = new StatisticsComputer("\t");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath), "UTF-8"));
            String line = "";
            while ((line = reader.readLine()) != null) sc.setLine(line);
        } catch (IOException e) {
            throw e;
        }

        return sc.getStatistics();
    }
}
