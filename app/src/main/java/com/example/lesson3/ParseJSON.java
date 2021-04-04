package com.example.lesson3;

import android.content.Context;

import java.util.ArrayList;

public class ParseJSON {
    static String[] parseJson(Context context) {
        ReadJSON readJSON = new ReadJSON();
        return readJSON.getJsonDataFromAsset(context, "questions.json").split(",");
    }

    public static ArrayList<ObjectJSON> getObjectsJSON(Context context) {
        ArrayList<ObjectJSON> objectJSONS = new ArrayList<>();
        String[] parsedQuestions = parseJson(context);

        for (int i = 0; i < parsedQuestions.length; i++) {
            String[] parse = parsedQuestions[i].split(":");
            parse[0] = parse[0].replaceAll("\"", "");
            parse[1] = parse[1].replaceAll("\"", "");
            objectJSONS.add(new ObjectJSON(parse[0], parse[1]));
        }
        return objectJSONS;
    }
}


