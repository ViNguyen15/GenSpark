import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Scanner;

public class MainApplication extends Application {
    Scene scene1, scene2, scene3, scene4, scene5;
    GameTester game = new GameTester();

    ImageLoader image = new ImageLoader();

    Image currentImage = image.img0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(animation());
        System.out.println("hi");
        //primaryStage.setScene(greatPlateau());

        primaryStage.show();
    }

    public Scene animation(){
        StackPane root = new StackPane();
        Scene scene = new Scene(root,800,800);

        scene.setOnKeyReleased(event -> {
            String direction = "";
            Image img = currentImage;
            System.out.println( event.getCode() );

            switch(event.getCode()){
                case UP: direction = "north";
                    break;
                case DOWN: direction = "south";
                    break;
                case LEFT: direction = "west";
                    break;
                case RIGHT: direction = "east";
                    break;
            }
            System.out.println(direction);

            img = imageDestroyer(direction);

            game.goblinDecision();
            System.out.println(game.getGoblinRoomName());
            
            BackgroundImage bImg = new BackgroundImage(
                    img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT
            );

            Background bGround = new Background(bImg);
            root.setBackground(bGround);
        });

        return scene;
    }

    //
    public Image imageDestroyer(String direction){
        game.specialMove(direction);
        roomImage();
        return currentImage;
    }

    public void roomImage(){
        switch (game.currentRoom.getName()){

            case "Great Plateau": currentImage = image.img0;
            break;
            case "Boss Room" : currentImage = image.img1;
            break;
            case "The Awakening Chamber" : currentImage = image.img2;
            break;
            case "The Brittle Path" : currentImage = image.img3;
            break;
            case "Death Mountain" : currentImage = image.img4;
            break;
            case "Icy Peak" : currentImage = image.img5;
            break;
            case "The Chamber of Secrets" : currentImage = image.img6;
            break;
            default: currentImage = currentImage;
        }


    }

    public Scene sceneMaker(Image img){

        StackPane root = new StackPane();
        scene1 = new Scene(root,500,500);
        BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background bGround = new Background(bImg);
        root.setBackground(bGround);

        return scene1;
    }

    public Scene greatPlateau(){

        Label lb = new Label("Great Plateau");

        StackPane root = new StackPane();
        scene1 = new Scene(root,500,500);
        BackgroundImage bImg = new BackgroundImage(image.img1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background bGround = new Background(bImg);
        root.setBackground(bGround);


        return scene1;
    }







    public static void main(String[] args) {
        launch(args);
    }



}
