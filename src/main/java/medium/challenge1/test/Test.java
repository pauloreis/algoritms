package medium.challenge1.test;

// https://github.com/Ontraport/Backend-Test

import com.google.gson.Gson;
import medium.challenge1.model.One;
import medium.challenge1.model.TheJson;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        String json = "{" +
                            "\"one\": {\n" +
                                "\"two\": 3,\n" +
                                "\"four\": [5, 6, 7]\n" +
                            "},\n" +
                            "\"eight\": {\n" +
                                "\"nine\": {\n" +
                                    "\"ten\": 11\n" +
                                "}\n" +
                            "}\n" +
                        "}";
        Gson gson = new Gson();
        TheJson theJson = gson.fromJson(json, TheJson.class);

        System.out.println(theJson);

        Field[] declaredFields = theJson.getClass().getDeclaredFields();
        for(Field field: declaredFields){
            Field[] declaredFields1 = theJson.getOne().getClass().getDeclaredFields();
            System.out.print(field.getName());
            for(Field field1: declaredFields) {
                System.out.println(field1.getName());
            }
        }
    }
}
