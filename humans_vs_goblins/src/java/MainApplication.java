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

    static Image
        img0 = new Image("https://www.phoenixfm.com/wp-content/uploads/2018/03/great-plateau.jpg"),
        img1 = new Image("https://preview.redd.it/kjjmvf4gx3k71.png?width=1024&format=png&auto=webp&s=e128f57b5db25c981953aca2c6dcfea1f8bde520"),
        img2 = new Image("https://i0.wp.com/www.followchain.org/wp-content/uploads/2021/12/Screenshot-315.png?fit=990%2C557&ssl=1"),
        img3 = new Image("https://attackofthefanboy.com/wp-content/uploads/2016/03/Zelda-Twilight-Princess-HD-Guide-Where-is-the-Bridge-of-Eldin-and-how-to-fix-it-760x428.jpg"),
        img4 = new Image("https://preview.redd.it/ko1r5ly2rcf61.jpg?width=640&crop=smart&auto=webp&s=75e09d9f02b180c80e95fffc0c67467629bac37c"),
        img5 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyq3EO539o6a520atJov_sPEG4zPMVbjtF0A&usqp=CAU"),
        img6 = new Image("https://static.wikia.nocookie.net/harrypotter/images/6/62/Chamber.png/revision/latest?cb=20180613173723");


    @Override
    public void start(Stage primaryStage) throws Exception {

        Image[] imgTester = {img0, img1, img2, img3, img4, img5, img6};




        primaryStage.setScene(animation());

        primaryStage.setScene(greatPlateau());
        primaryStage.show();


    }

    public Scene animation(){
        StackPane root = new StackPane();
        Scene scene = new Scene(root,400,400);

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                Image img = img0;

                System.out.println( event.getCode() );

                switch(event.getCode()){
                    case UP: ;
                        break;
                    case DOWN: ;
                        break;
                    case LEFT: img = img1;
                        break;
                    case RIGHT: img = img0;
                        break;
                }

                BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
                Background bGround = new Background(bImg);
                root.setBackground(bGround);
            }
        });
        return scene;
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
        BackgroundImage bImg = new BackgroundImage(img1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background bGround = new Background(bImg);
        root.setBackground(bGround);

        return scene1;
    }







    public static void main(String[] args) {
        launch(args);
    }



}
