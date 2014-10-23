package main;

import bastics.Bastics;
import bastics.Statistics;
import io.FileIO;
import io.MdFormatter;
import util.Setting;

/**
 * Entry point class
 */
public class EntryPoint {

    public static void main(String[] args) throws Exception {

        // read a setting file
        Setting setting = FileIO.readSettingFile();

        // branch with type
        String type = setting.getString("type");
        Statistics result = null;
        switch (type) {
            case "file":
                result = Bastics.computeBasicStatistics(setting.getString("path"));
                break;
            case "jdbc":
                break;
        }
        if (result==null) {
            System.err.println("error in bastics");
            return;
        }

        // format results with md
        String content = MdFormatter.format(result);

        // save results to file
        FileIO.saveFile(setting.getString("output"), content);

    }
}
