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

public class ProduitController implements Initializable {

    @FXML
    private Button btnajouter;

    @FXML
    private Button btnclear;

    @FXML
    private Button btnmodifier;

    @FXML
    private Button btnsupprimer;

    @FXML
    private TableColumn<Livreur, Integer> colidcommande;

    @FXML
    private TableColumn<Livreur, String> colidproduit;

    @FXML
    private TableColumn<Livreur, String> collabel;

    @FXML
    private TableColumn<Livreur, String> colprix;

    @FXML
    private TableView<Produit> table;

    @FXML
    private TextField tidcommande;

    @FXML
    private TextField tlabel;

    @FXML
    private TextField tprix;

    @FXML
    void ajouterproduit(ActionEvent event) {
        Produit cmd=new Produit();
        cmd.setIdcommande(Integer.parseInt(tidcommande.getText()));
        cmd.setLabel(tlabel.getText());
        cmd.setPrix(Float.parseFloat(tprix.getText()));

        ProduitDAO cmdao = new ProduitDAO();
        cmdao.savep(cmd);
        showlivreurs();
        clear();
    }

    @FXML
    void cleartable(ActionEvent event) {
        ProduitDAO cmd = new ProduitDAO();
        cmd.clear();
        showlivreurs();
        clear();
    }
    void clear(){
        tlabel.setText(null);
        tidcommande.setText(null);
        tprix.setText(null);
        btnajouter.setDisable(false);
    }
    public  ObservableList<Produit> getDataProduit(){

        ProduitDAO produitDAO = null;

        ObservableList<Produit> listfcx = FXCollections.observableArrayList();

        produitDAO = new ProduitDAO();
        for (Produit ettemp : produitDAO.getallp())
            listfcx.add(ettemp);

        return listfcx ;
    }
    public void showlivreurs(){
        ObservableList<Produit> list = getDataProduit();
        table.setItems(list);
        colidcommande.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("Idcommande"));
        colidproduit.setCellValueFactory(new PropertyValueFactory<Livreur,String>("idproduit"));
        collabel.setCellValueFactory(new PropertyValueFactory<Livreur,String>("Label"));
        colprix.setCellValueFactory(new PropertyValueFactory<Livreur,String>("prix"));

    }

    @FXML
    void getData(MouseEvent event) {
        Produit cmd =table.getSelectionModel().getSelectedItem();
       int idc = cmd.getIdproduit();

        tlabel.setText(cmd.getLabel());
        tprix.setText(String.valueOf(cmd.getPrix()));
        tidcommande.setText(String.valueOf(cmd.getIdcommande()));
        btnajouter.setDisable(true);
    }

    @FXML
    void modifierproduit(ActionEvent event) {
        Produit cmd= new Produit();
        ProduitDAO dao = new ProduitDAO();
        cmd.setPrix(Float.parseFloat(tprix.getText()));
        cmd.setLabel(tlabel.getText());
        cmd.setIdcommande(Integer.parseInt(tidcommande.getText()));
        Produit check =table.getSelectionModel().getSelectedItem();
        int idc = check.getIdproduit();
        dao.updatep(cmd,idc);


        showlivreurs();
        clear();
    }

    @FXML
    void supprimerproduit(ActionEvent event) {
        ProduitDAO liv=new ProduitDAO();
        Produit cmd =table.getSelectionModel().getSelectedItem();
       int idc = cmd.getIdproduit();
        liv.supprimerp(idc);

        showlivreurs();
        clear();
    }

    @FXML
    void switchToTracking1(ActionEvent event) {
        Parent trackingParent = null;
        try {
            trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/Livreur.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene trackingScene = new Scene(trackingParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(trackingScene);
        window.show();
    }
    @FXML
    void switchToTracking2(ActionEvent event) {
        Parent trackingParent = null;
        try {
            trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/Commande.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
showlivreurs();
    }
}
