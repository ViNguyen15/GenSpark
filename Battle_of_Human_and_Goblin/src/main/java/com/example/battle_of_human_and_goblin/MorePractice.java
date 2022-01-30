package com.example.battle_of_human_and_goblin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MorePractice extends Application {

    Stage windows;
    Scene scene1, scene2;





    @Override
    public void start(Stage stage) throws Exception {
        windows = stage;


        windows.setScene(woods());
        windows.setTitle("Heavens Feel");
        windows.show();

    }

    public Scene woods(){

        Label label1 = new Label("Welcome to the first scene");
        Button btn1 = new Button("Go to scene 2");
        btn1.setOnAction( e -> windows.setScene( realityMarble() ) );

        //layout 1- children are laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, btn1);
        scene1 = new Scene(layout1, 200, 200);


        return scene1;
    }

    public Scene realityMarble(){

        Button btn2 = new Button("This scene sucks, go back to scene 1");
        btn2.setOnAction( e->windows.setScene( woods() ) );

        //layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(btn2);
        scene2 = new Scene(layout2, 600,300);

        return scene2;
    }

































    public static void main(String[] args) {
        launch(args);
    }

}
