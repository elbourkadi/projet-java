package com.fstt.trackingli;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {

    @FXML
    private Button btnajouter;
    int idc=0;

    @FXML
    private Button btnclear;

    @FXML
    private Button btnmodifier;

    @FXML
    private Button btnsupprimer;

    @FXML
    private TableColumn<Livreur, String> coladresse;

    @FXML
    private TableColumn<Livreur, String> coldebut;

    @FXML
    private TableColumn<Livreur, String> colfin;

    @FXML
    private TableColumn<Livreur, String> colid;

    @FXML
    private TableColumn<Livreur, Integer> colidcommande;

    @FXML
    private TableView<Commande> table;

    @FXML
    private TextField tadresse;

    @FXML
    private TextField tdebut;
    @FXML
    private TextField tid;

    @FXML
    private TextField tfin;








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showlivreurs();
    }


    public  ObservableList<Commande> getDatacommande(){

        CommandeDAO commandeDAO = null;

        ObservableList<Commande> listfcx = FXCollections.observableArrayList();

        commandeDAO = new CommandeDAO();
        for (Commande ettemp : commandeDAO.getallc())
            listfcx.add(ettemp);

        return listfcx ;
    }
    public void showlivreurs(){
        ObservableList<Commande> list = getDatacommande();
        table.setItems(list);
        colidcommande.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("idcommande"));
        coladresse.setCellValueFactory(new PropertyValueFactory<Livreur,String>("Adresse"));
        coldebut.setCellValueFactory(new PropertyValueFactory<Livreur,String>("date_debut"));
        colfin.setCellValueFactory(new PropertyValueFactory<Livreur,String>("date_fin"));
        colid.setCellValueFactory(new PropertyValueFactory<Livreur,String>("id"));

    }
    @FXML
    void ajoutercommande(ActionEvent event) {

        Commande cmd=new Commande();
        cmd.setAdresse(tadresse.getText());
        cmd.setDate_debut(tdebut.getText());
        cmd.setDate_fin(tfin.getText());
        cmd.setId(Integer.parseInt(tid.getText()));
        CommandeDAO cmdao = new CommandeDAO();
        cmdao.savec(cmd);
        showlivreurs();
        clear();

    }


    @FXML
     void getData(MouseEvent event) {
        Commande cmd =table.getSelectionModel().getSelectedItem();
        idc = cmd.getIdcommande();

        tadresse.setText(cmd.getAdresse());
        tdebut.setText(cmd.getDate_debut());
        tfin.setText(cmd.getDate_fin());
        tid.setText(String.valueOf(cmd.getId()));

        mixedDAO mix= new mixedDAO();
        mix.setCount(cmd.getIdcommande());

        btnajouter.setDisable(true);
    }

    @FXML
    void supprimercommande(ActionEvent event) {
        CommandeDAO liv=new CommandeDAO();
        Commande cmd =table.getSelectionModel().getSelectedItem();
        idc = cmd.getIdcommande();
        liv.supprimerc(idc);

        showlivreurs();
        clear();

    }

    @FXML
    void modifiercommande(ActionEvent event) {
        Commande cmd= new Commande();
        CommandeDAO dao = new CommandeDAO();
        cmd.setAdresse(tadresse.getText());
        cmd.setDate_debut(tdebut.getText());
        cmd.setDate_fin(tfin.getText());
        Commande check =table.getSelectionModel().getSelectedItem();
        idc = check.getIdcommande();
        dao.updatec(cmd,idc);


        showlivreurs();
        clear();


    }
    @FXML
    void cleartable(ActionEvent event){
        CommandeDAO cmd = new CommandeDAO();
        cmd.clear();
        showlivreurs();
        clear();
    }



    void clear(){
        tadresse.setText(null);
        tdebut.setText(null);
        tfin.setText(null);
        btnajouter.setDisable(false);
    }
    @FXML
    void switchToTracking1(ActionEvent event) throws IOException {



        Parent trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/Produit.fxml"));
        Scene trackingScene = new Scene(trackingParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(trackingScene);
        window.show();


    }
    @FXML
    void switchToTracking2(ActionEvent event) throws IOException {



        Parent trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/Livreur.fxml"));
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
    @FXML
    void switchToTracking4(ActionEvent event) {
        Parent trackingParent = null;
        try {
            trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/Panier.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene trackingScene = new Scene(trackingParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(trackingScene);
        window.show();
    }
}



