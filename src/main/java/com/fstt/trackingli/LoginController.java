package com.fstt.trackingli;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Login;
import model.LoginDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class LoginController implements Initializable {
    public TextField username;
    public PasswordField password;
    public Button login;
    @FXML
    private ImageView glovo;
    public void initialize(URL url, ResourceBundle resourceBundle){
        TranslateTransition transition =new TranslateTransition();
        transition.setNode(glovo);
        transition.setDuration(Duration.millis(7000));
        transition.setByX(-700);

        transition.play();



    }
    private Stage stage;
    private Scene scene;
    @FXML
    void switchToTracking(ActionEvent event) throws IOException {
        Login lo=new Login();
        LoginDAO log=new LoginDAO();
        lo.setUsername(username.getText());
        lo.setPassword(password.getText());

        boolean test =log.login(lo);
        if(test){
        Parent trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/Livreur.fxml"));
        Scene trackingScene = new Scene(trackingParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(trackingScene);
        window.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password");
            alert.showAndWait();
        }
    }



}
