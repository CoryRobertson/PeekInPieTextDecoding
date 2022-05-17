package com.github.coryrobertson.peekinpietextdecoding;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application
{

    public final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        //String digits = readFile(new File("./pi-one-million.txt"));
        String digits = "00010203040506070809101112131415161718192021222324252627";
        String[] groups = convertToGroups(digits);
        String converted = convertGroupsToLetters(groups);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
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

    private String[] convertToGroups(String digits)
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

    private String digitToLetter(String input)
    {
        int number = Integer.parseInt(input) % 26;
        //String letters = "abcdefghijklmnopqrstuvwxyz";
        return String.valueOf(alphabet.charAt(number));
    }

    private String convertGroupsToLetters(String[] groups)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < groups.length; i++)
        {
            sb.append(digitToLetter(groups[i]));
        }
        return sb.toString();
    }
}
