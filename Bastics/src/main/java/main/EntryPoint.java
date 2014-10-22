package main;

import io.FileIO;
import util.Setting;

/**
 * Entry point class
 */
public class EntryPoint {

    public static void main(String[] args) throws Exception {

        // TODO: read a setting file
        Setting setting = FileIO.readSettingFile();

        // TODO: branch with type

            // TODO: if file

            // TODO: if jdbc

        // TODO: get results

        // TODO: compute basic statistics

        // TODO: format results with md

        // TODO: save results to file
        FileIO.saveFile(setting.getString("output"), "test");

    }
}
