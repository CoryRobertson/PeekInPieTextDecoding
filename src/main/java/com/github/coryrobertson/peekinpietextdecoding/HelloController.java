package com.github.coryrobertson.peekinpietextdecoding;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label outputText1;

    @FXML
    private Label outputText2;

    @FXML
    private TextField textField;

    @FXML
    private TextField textField2;

    @FXML
    protected void onButton2Click()
    {
        if(!textField2.getText().isEmpty())
        {
            String input = textField2.getText();
            input = input.replaceAll("\\s","");
            outputText2.setText(HelloApplication.convertDigitsToLetters(input));
        }
    }

    @FXML
    protected void onHelloButtonClick()
    {
        if(!textField.getText().isEmpty())
        {
            String input = textField.getText();
            input = input.replaceAll("\\s", "");
            String output;
            //String converted = HelloApplication.convertDigitsToLetters(input);
            int index = HelloApplication.piConverted.indexOf(input); // index at which the word shows up

            if(index < 0)
            {
                //if index is less than 0 the word was not found, and we can exit the function and change the output text
                outputText1.setText("Word not found.");
                return;
            }

            int indexDisplay = index + 1; // variable to make index 0 = 1 for user display

            //index and input text append
            //output += ("index: " + indexDisplay + "\ninput text: " + input + "\n");

            int marginFront = 4;
            int marginBack = 4;

            //change margins depending on end and front of file so no index out of bounds exceptions occur
            if(index < marginFront) {marginFront = index;}
            if(index + input.length() + marginBack > HelloApplication.piConverted.length()) {marginBack = HelloApplication.piConverted.length() - index - input.length();}

            //data with index and input text shown to user
            String data = ("index: " + indexDisplay + "\ninput text: " + input + "\n");

            //text with margin for user
            String textWithMargin = HelloApplication.piConverted.substring(index - marginFront, index + input.length() + marginBack) + "\n";
            //output += HelloApplication.piConverted.substring(index - margin, index + input.length() + margin) + "\n";

            //front margin
            String frontMargin = HelloApplication.piText.substring((index - marginFront) * 2, (index * 2));
            //output += HelloApplication.piText.substring((index - margin) * 2, (index * 2));

            //output
            String outputMargin = "->" + HelloApplication.piText.substring((index) * 2, (index + input.length()) * 2) + "<-";
            //output += "    ->    " + HelloApplication.piText.substring((index) * 2, (index + input.length()) * 2) + "    <-    ";

            //back margin
            String backMargin = HelloApplication.piText.substring((index + input.length()) * 2, (index + input.length() + marginBack) * 2);
            //output += HelloApplication.piText.substring((index + input.length()) * 2, (index + input.length() + margin) * 2);



            output = data + textWithMargin + spaceOutEveryTwo(frontMargin) + spaceOutEveryTwo(outputMargin) + spaceOutEveryTwo(backMargin);

            outputText1.setText(output);

        }
        else
        {
            outputText1.setText("");
        }
    }

    public String spaceOutEveryTwo(String input)
    {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < input.length(); i++)
        {
            output.append(input.charAt(i));
            if(i % 2 == 1)
            {
                output.append(" ");
            }
        }
        return output.toString();
    }
}