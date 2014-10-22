package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Setting entity class
 */
public class Setting {

    private static Map<String, Object> setting;

    private static Setting instance = new Setting();
    private Setting() {}
    public static Setting getInstance() {

        setting = new HashMap<>();
        return instance;
    }

    public String getString(String key) {
        return (String) setting.get(key);
    }

    public void setSettings(String[] components) {

        for (String c : components) {
            String[] kv = c.split("\t");
            addKeyValue(kv[0], kv[1]);
        }
    }

    public void addKeyValue(String key, Object value) {
        setting.put(key, value);
    }

    @Override
    public String toString() {
        return setting.toString();
    }
}
