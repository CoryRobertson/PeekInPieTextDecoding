package com.github.coryrobertson.peekinpietextdecoding;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label outputText;

    @FXML
    private TextField textField;

    @FXML
    protected void onHelloButtonClick()
    {
        if(!textField.getText().isEmpty())
        {
            outputText.setText(textField.getText());
        }
        else
        {
            outputText.setText("");
        }
    }
}