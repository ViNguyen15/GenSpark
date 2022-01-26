package com.example.battle_of_human_and_goblin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Button btn;
    int count = 0;
    String  line1 = "I am the bone of my Sword",
            line2 = "Steel is my body and fire is my Blood",
            line3 = "I have created over a Thousand Blades",
            line4 = "Unknown to death nor known to life",
            line5 = "Have withstood pain to create many weapons",
            line6 = "Yet, those hands will never hold anything",
            line7 = "So as I pray... UNLIMITED BLADE WORKS!!!";

    @Override
    public void start(Stage stage) {
        stage.setTitle("Unlimited Blade Works");
        btn = new Button();
        btn.setText("Are you my master?");

        btn.setOnAction(e -> realityMarble());

        StackPane layout = new StackPane();

        layout.getChildren().add(btn);

        Scene scene = new Scene(layout, 400, 400);


        stage.setScene(scene);
        stage.show();



    }

    public void realityMarble(){
        String invoke = "";
        switch (count){
            case 0:
                invoke = line1;
                break;
            case 1:
                invoke = line2;
                break;
            case 2:
                invoke = line3;
                break;
            case 3:
                invoke = line4;
                break;
            case 4:
                invoke = line5;
                break;
            case 5:
                invoke = line6;
                break;
            case 6:
                invoke = line7;
                break;
            default: invoke = String.valueOf(count);
        }
        count++;
        System.out.println(invoke);
        if(count%15==0)
            count=0;
        return;
    }


    public static void main(String[] args) {
        launch();
    }
}