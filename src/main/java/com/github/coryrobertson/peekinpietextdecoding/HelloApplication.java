package com.github.coryrobertson.peekinpietextdecoding;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application
{

    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String piText;

    public static String piConverted;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        piText = readFile(new File("./pi-one-million.txt"));
        piConverted = convertDigitsToLetters(piText);
        int index = piConverted.indexOf("cory");
        String digitsForIndex = piText.substring(index, index + ("cory".length() * 2));

        File output = new File("./output.txt");
        FileWriter fw = new FileWriter(output);
        fw.write(piConverted);
        fw.close();

//        int test1 = convertToGroups(piText).length;
//        int test2 = convertGroupsToLetters(convertToGroups(piText)).length();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static String convertDigitsToLetters(String digits)
    {
        String letters;

        String[] groups = convertToGroups(digits);
        letters = convertGroupsToLetters(groups);

        return letters;
    }

    private String readFile(File file)
    {
        String digits = "";


        try {
            digits = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        digits = digits.replaceAll("\n","");

        return digits;
    }

    private static String[] convertToGroups(String digits)
    {
        String[] groups = new String[digits.length()];
        ArrayList<String> arr = new ArrayList<>();


        for(int i = 0; i < digits.length(); i+=2)
        {
            if(digits.length() % 2 == 0 || i < digits.length() - 2)
            {
//                groups[i] = digits.charAt(i) + String.valueOf(digits.charAt(i + 1));
                arr.add(digits.charAt(i) + String.valueOf(digits.charAt(i + 1)));
            }
            else
            {
//                groups[i] = String.valueOf(digits.charAt(i));
                arr.add(String.valueOf(digits.charAt(i)));
            }
        }

        return arr.toArray(new String[0]);
    }

    private static String digitToLetter(String input)
    {
        int number = Integer.parseInt(input) % 26;

        return String.valueOf(alphabet.charAt(number));
    }

    private static String convertGroupsToLetters(String[] groups)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < groups.length; i++)
        {
            sb.append(digitToLetter(groups[i]));
        }
        return sb.toString();
    }
}
