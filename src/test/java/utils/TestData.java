package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class TestData {

    private static JSONObject testData;

    static {
        try {
            JSONParser parser = new JSONParser();
            testData = (JSONObject) parser.parse(new FileReader("src/test/resources/testdata.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String section, String key) {
        JSONObject sectionData = (JSONObject) testData.get(section);
        if (sectionData != null) {
            Object value = sectionData.get(key);
            return value != null ? value.toString() : null;
        }
        return null;
    }
}