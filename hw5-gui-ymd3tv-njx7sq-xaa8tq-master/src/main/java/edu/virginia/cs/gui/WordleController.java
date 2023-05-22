package edu.virginia.cs.gui;

import edu.virginia.cs.wordle.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Vector;

public class WordleController {

    Wordle wordle;

    private int ListIndex = 0;
    private List<TextField> TextFieldList = new Vector<TextField>();
    @FXML
    private Label gameText;
    @FXML
    private Button yes;
    @FXML
    private Button no;


    @FXML
    private TextField l00;
    @FXML
    private TextField l10;
    @FXML
    private TextField l20;
    @FXML
    private TextField l30;
    @FXML
    private TextField l40;
    @FXML
    private TextField l01;
    @FXML
    private TextField l11;
    @FXML
    private TextField l21;
    @FXML
    private TextField l31;
    @FXML
    private TextField l41;
    @FXML
    private TextField l02;
    @FXML
    private TextField l12;
    @FXML
    private TextField l22;
    @FXML
    private TextField l32;
    @FXML
    private TextField l42;
    @FXML
    private TextField l03;
    @FXML
    private TextField l13;
    @FXML
    private TextField l23;
    @FXML
    private TextField l33;
    @FXML
    private TextField l43;
    @FXML
    private TextField l04;
    @FXML
    private TextField l14;
    @FXML
    private TextField l24;
    @FXML
    private TextField l34;
    @FXML
    private TextField l44;
    @FXML
    private TextField l05;
    @FXML
    private TextField l15;
    @FXML
    private TextField l25;
    @FXML
    private TextField l35;
    @FXML
    private TextField l45;
    @FXML
    private GridPane grid;

    private void initialize() {
        isInitialized = true;
        wordle = new WordleImplementation();
        TextFieldList.add(l00);
        TextFieldList.add(l10);
        TextFieldList.add(l20);
        TextFieldList.add(l30);
        TextFieldList.add(l40);
        TextFieldList.add(l01);
        TextFieldList.add(l11);
        TextFieldList.add(l21);
        TextFieldList.add(l31);
        TextFieldList.add(l41);
        TextFieldList.add(l02);
        TextFieldList.add(l12);
        TextFieldList.add(l22);
        TextFieldList.add(l32);
        TextFieldList.add(l42);
        TextFieldList.add(l03);
        TextFieldList.add(l13);
        TextFieldList.add(l23);
        TextFieldList.add(l33);
        TextFieldList.add(l43);
        TextFieldList.add(l04);
        TextFieldList.add(l14);
        TextFieldList.add(l24);
        TextFieldList.add(l34);
        TextFieldList.add(l44);
        TextFieldList.add(l05);
        TextFieldList.add(l15);
        TextFieldList.add(l25);
        TextFieldList.add(l35);
        TextFieldList.add(l45);
        for (int i = 0; i < TextFieldList.size(); i++) {
            TextFieldList.get(i).setEditable(false);
        }
    }

    @FXML
    private TextField EntryField;

    private boolean isInitialized = false;

    private LetterResult[] guessResult;
    private int segment = 0;

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @FXML
    protected void onTyped(KeyEvent event) {
        if (!isInitialized) {
            initialize();
        }
        if (wordle.isGameOver() == false) {
            String x = event.getText().toUpperCase();
            if (event.getCode().equals(KeyCode.BACK_SPACE)) {
                delete();
            } else if (event.getCode().equals(KeyCode.ENTER)) {
                enterGuess();
            } else if (alphabet.contains(x)) {
                addToBox(x);
            }
        }

    }

    protected void addToBox(String l) {
        if (ListIndex <= 4 + segment) {
            TextFieldList.get(ListIndex).setText(l);
            ListIndex++;
        }
    }

    protected void delete() {
        if (ListIndex > segment) {
            for (int i = TextFieldList.size() - 1; i >= 0; i--) {
                if (!(TextFieldList.get(i).getText().equals(""))) {
                    TextFieldList.get(i).setText("");
                    ListIndex--;
                    gameText.setText("");
                    break;
                }
            }
        }
    }

    @FXML
    protected void enterGuess() {
        System.out.println(wordle.getAnswer());
        String guess = "";
        for (int x = 0 + segment; x <= 4 + segment; x++) {
            guess += TextFieldList.get(x).getText();
        }
        if (ListIndex == 5 + segment) {
            try {
                int inc = 0;
                guessResult = wordle.submitGuess(guess);
                for (int i = 0; i < 5; i++) {
                    if (guessResult[i] == LetterResult.GRAY) {
                        TextFieldList.get(ListIndex - 5 + inc).setStyle("-fx-background-color: #b8b6b2;");
                    }
                    if (guessResult[i] == LetterResult.GREEN) {
                        TextFieldList.get(ListIndex - 5 + inc).setStyle("-fx-background-color: #16c751;");
                    }
                    if (guessResult[i] == LetterResult.YELLOW) {
                        TextFieldList.get(ListIndex - 5 + inc).setStyle("-fx-background-color: #d6d627;");
                    }
                    inc++;
                }
                segment += 5;
            } catch (IllegalWordException e) {
                gameText.setText("Not a valid guess");
            }

        }
        if (wordle.isGameOver()) {
            gameOver();
        }


    }


    private void reset() {
        ListIndex = 0;
        segment = 0;
        gameText.setText("");
        wordle = new WordleImplementation();
        for (int i = 0; i < TextFieldList.size(); i++) {
            TextFieldList.get(i).setText("");
            TextFieldList.get(i).setStyle("-fx-background-color: White");
            TextFieldList.get(i).setStyle("-fx-border-color-color: Black");
        }
        no.setVisible(false);
        yes.setVisible(false);
    }

    private void quit() {
        Stage stage = (Stage) no.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleYesButtonPress(ActionEvent event) {
        reset();

    }

    @FXML
    private void handleNoButtonPress(ActionEvent event) {
        quit();
    }

    private void gameOver() {
        no.setVisible(true);
        yes.setVisible(true);
        for (int i = 0; i < TextFieldList.size(); i++) {
            TextFieldList.get(i).setEditable(false);
        }
        if (wordle.isWin()) {
            gameText.setText("You Won! Play Again?");

        }
        if (wordle.isLoss()) {
            gameText.setText("You Lost! Play Again?");
        }
    }
}


