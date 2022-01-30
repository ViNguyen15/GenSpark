import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageLoader extends Application {

    static String
            path0 = "src/resources/great-plateau.jpg",
            path1 = "src/resources/bossRoom.png",
            path2 = "src/resources/awakeningChamber.png",
            path3 = "src/resources/brittledBridge.jpg",
            path4 = "src/resources/deathMountain.jpg",
            path5 = "src/resources/IcyPeaks.jpg",
            path6 = "src/resources/chamberOfSecrets.png";

    static Image
            img0 = new Image("file:" + path0),
            img1 = new Image("file:" + path1),
            img2 = new Image("file:" + path2),
            img3 = new Image("file:" + path3),
            img4 = new Image("file:" + path4),
            img5 = new Image("file:" + path5),
            img6 = new Image("file:" + path6);


    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Scene scene = new Scene(root,500,500);

        Image img = img0;

        BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background bGround = new Background(bImg);
        root.setBackground(bGround);



        primaryStage.setTitle("Testing image");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
