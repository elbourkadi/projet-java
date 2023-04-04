package com.fstt.trackingli;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Livreur;
import model.LivreurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Login;
import model.LoginDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LivreurController implements Initializable {
Connection con =null;
PreparedStatement st=null;
ResultSet rs = null;
    @FXML
    private Button btnajouter;

    @FXML
    private Button btnclear;

    @FXML
    private Button btnmodifier;

    @FXML
    private Button btnsupprimer;
    @FXML
    private TableColumn<Livreur, Integer> colid1 ;

    @FXML
    private TableColumn<Livreur,String>colnom1;
int id =0;
    @FXML
    private TableColumn<Livreur, String> colprenom1;

    @FXML
    private TableColumn<Livreur, String> coltele;

    @FXML
    private TableView<Livreur> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showlivreurs();
    }


    public static ObservableList<Livreur> getDataLivreurs(){

        LivreurDAO livreurDAO = null;

        ObservableList<Livreur> listfx = FXCollections.observableArrayList();

        livreurDAO = new LivreurDAO();
        for (Livreur ettemp : livreurDAO.getall())
            listfx.add(ettemp);

        return listfx ;
    }


    public void showlivreurs(){
        ObservableList<Livreur> list = getDataLivreurs();
        table.setItems(list);
        colid1.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("id"));
        colnom1.setCellValueFactory(new PropertyValueFactory<Livreur,String>("Nom"));
        colprenom1.setCellValueFactory(new PropertyValueFactory<Livreur,String>("Prenom"));
        coltele.setCellValueFactory(new PropertyValueFactory<Livreur,String>("Telephone"));
    }

    @FXML
    private TextField tnom1;

    @FXML
    private TextField tprenom1;

    @FXML
    private TextField ttelephone1;


    @FXML
    void ajouterlivreur(ActionEvent event) {

        Livreur li=new Livreur();
        li.setNom(tnom1.getText());
        li.setPrenom(tprenom1.getText());
        li.setTelephone(ttelephone1.getText());
    LivreurDAO livr = new LivreurDAO();
    livr.save(li);
    showlivreurs();
        clear();

    }


    @FXML
    void getData(MouseEvent event) {
Livreur li =table.getSelectionModel().getSelectedItem();
id = li.getId();
tnom1.setText(li.getNom());
        tprenom1.setText(li.getPrenom());
        ttelephone1.setText(li.getTelephone());
        btnajouter.setDisable(true);
    }
    @FXML
    void supprimerlivreur(ActionEvent event) {
        LivreurDAO liv=new LivreurDAO();
        Livreur li =table.getSelectionModel().getSelectedItem();
        id = li.getId();
        liv.supprimer(id);

        showlivreurs();
        clear();

    }

    @FXML
    void modifierlivreur(ActionEvent event) {
        Livreur li= new Livreur();
        LivreurDAO livr = new LivreurDAO();
        li.setNom(tnom1.getText());
        li.setPrenom(tprenom1.getText());
        li.setTelephone(ttelephone1.getText());
        Livreur check =table.getSelectionModel().getSelectedItem();
        id = check.getId();
livr.update(li,id);


        showlivreurs();
        clear();


    }
    @FXML
    void cleartable(ActionEvent event){
        LivreurDAO livr = new LivreurDAO();
        livr.clear();
        showlivreurs();
        clear();
    }



    void clear(){
tnom1.setText(null);
tprenom1.setText(null);
ttelephone1.setText(null);
btnajouter.setDisable(false);
    }
    @FXML
    void switchToTracking1(ActionEvent event) throws IOException {



            Parent trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/Commande.fxml"));
            Scene trackingScene = new Scene(trackingParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(trackingScene);
            window.show();


        }
    @FXML
    void switchToTracking2(ActionEvent event) throws IOException {



        Parent trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/Produit.fxml"));
        Scene trackingScene = new Scene(trackingParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(trackingScene);
        window.show();


    }
    @FXML
    void switchToTracking3(ActionEvent event) {
        Parent trackingParent = null;
        try {
            trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/log.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene trackingScene = new Scene(trackingParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(trackingScene);
        window.show();
    }
    }




