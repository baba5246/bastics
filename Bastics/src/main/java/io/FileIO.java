package io;

import util.Setting;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * File io class
 */
public class FileIO {

    private static final String USER_DIR = "user.dir";
    private static final String CONFIG_FILE = "config.tsv";
    private static final String UTF_8 = "UTF-8";

    public static String readFile(String path) throws Exception {
        return readFile(new FileInputStream(path));
    }

    public static String readFile(InputStream is) throws Exception {

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, UTF_8));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            throw e;
        }
        return sb.toString();
    }

    public static Setting readSettingFile() throws Exception {

        Setting setting = Setting.getInstance();

        File file = getConfigFile();
        if (file == null) throw new FileIOException(CONFIG_FILE + " not found!");
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), UTF_8));
            List<String> configList = new ArrayList<>();
            String line = null;
            while ((line = reader.readLine()) != null) {
                configList.add(line);
            }
            String[] configs = configList.toArray(new String[0]);
            setting.setSettings(configs);

        } catch (IOException e) {
            throw e;
        }

        return setting;
    }

    private static File getConfigFile() {

        String cd = System.getProperty(USER_DIR);
        File[] list = new File(cd).listFiles();
        File setting = null;
        for (File f : list) {
            if (f.getName().equals(CONFIG_FILE)) {
                setting = f;
                break;
            }
        }
        return setting;
    }

    public static void saveFile(String outputPath, String file) throws Exception {

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputPath), UTF_8));
            writer.write(file);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw e;
        }
    }

    public static class FileIOException extends Exception {

        public FileIOException(String message) {
            super(message);
        }
    }
}
