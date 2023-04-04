package com.fstt.trackingli;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class  App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/Fxml/Admin.fxml"));
Scene scene = new Scene(parent);
stage.setTitle("GLOVO");
        Image icon=new Image("file:src/main/resources/images/glovologo.png");
        stage.getIcons().add(icon);

stage.setScene(scene);
        stage.setResizable(false);
        stage.setX(200);
        stage.setY(100);
stage.show();


    }
    public static  void main(String[] args){
        launch();
    }
}
