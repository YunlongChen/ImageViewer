package sample;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // load the image

        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gds = graphicsEnvironment.getScreenDevices();
        for (GraphicsDevice gd : gds) {
            int w = gd.getDisplayMode().getWidth();
            int h = gd.getDisplayMode().getHeight();
            System.out.println(w + "::" + h);

            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            System.out.println(gc.getBounds().x);
            System.out.println(gc.getBounds().y);
        }


        // TODO Auto-generated constructor stub
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        System.out.println("屏幕宽度：" + screenWidth + "，屏幕高度：" + screenHeight);

        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Pictures\\游戏\\赫炎的印加洛克\\艾提-黑猫.png"));
        Image image = new Image(fileInputStream);

        // simple displays ImageView the image as is
        ImageView iv1 = new ImageView();
        iv1.setImage(image);

        // resizes the image to have width of 100 while preserving the ratio and using
        // higher quality filtering method; this ImageView is also cached to
        // improve performance
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitWidth(100);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);

        // defines a viewport into the source image (achieving a "zoom" effect) and
        // displays it rotated
        ImageView iv3 = new ImageView();
        iv3.setImage(image);
        Rectangle2D viewportRect = new Rectangle2D(40, 35, 110, 110);
        iv3.setViewport(viewportRect);
        iv3.setRotate(90);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        HBox box = new HBox();
        box.getChildren().add(iv1);
        box.getChildren().add(iv2);
        box.getChildren().add(iv3);
        root.getChildren().add(box);

        primaryStage.setTitle("ImageView");
        primaryStage.setWidth(screenWidth);
        primaryStage.setHeight(screenHeight);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
