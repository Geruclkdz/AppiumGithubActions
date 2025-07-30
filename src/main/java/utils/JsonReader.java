package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public static String[][] getJsonData(String jsonFilePath, String key, int attributesCount) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject rootObject = (JSONObject) parser.parse(new FileReader(jsonFilePath));
        JSONArray dataArray = (JSONArray) rootObject.get(key);

        String[][] resultArray = new String[dataArray.size()][attributesCount];

        for (int i = 0; i < dataArray.size(); i++) {
            JSONObject item = (JSONObject) dataArray.get(i);
            resultArray[i][0] = String.valueOf(item.get("TaskName"));
            resultArray[i][1] = String.valueOf(item.get("TaskDesc"));
        }

        return resultArray;
    }
}