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
            outputText2.setText(HelloApplication.convertDigitsToLetters(textField2.getText()));
        }
    }

    @FXML
    protected void onHelloButtonClick()
    {
        if(!textField.getText().isEmpty())
        {
            String input = textField.getText();
            String output = "";
            //String converted = HelloApplication.convertDigitsToLetters(input);
            int index = HelloApplication.piConverted.indexOf(input);
            int indexDisplay = index + 1;

            output += ("index: " + indexDisplay + "\ninput text: " + input + "\n");
            final int margin = 2;
            output += HelloApplication.piConverted.substring(index - margin, index + input.length() + margin) + "\n";
            output += HelloApplication.piText.substring((index - margin) * 2, (index * 2));

            output += "    ->    " + HelloApplication.piText.substring((index) * 2, (index + input.length()) * 2) + "    <-    ";

            //String numbers = HelloApplication.piText.substring((index) * 2, (index + input.length()) * 2);

            output += HelloApplication.piText.substring((index + input.length()) * 2, (index + input.length() + margin) * 2);
//            output += HelloApplication.piText.substring((index - margin) * 2 , (index + input.length() + margin) * 2) + "\n";



            outputText1.setText(output);

        }
        else
        {
            outputText1.setText("");
        }
    }
}