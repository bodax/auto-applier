package sample;

import com.aquafx_project.AquaFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AquaFx.style();
        Parent root = FXMLLoader.load(getClass().getResource("/MainFrame.fxml"));
        primaryStage.setTitle("AutoHelp 3.0");
        primaryStage.setScene(new Scene(root, 1037, 409));
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.getIcons().add(new Image("file:address_book_32.png"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
