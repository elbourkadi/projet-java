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

public class mixedController implements Initializable {

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
    private TableColumn<Livreur, String> colqte;

    @FXML
    private TableColumn<Livreur, String> colidproduit;

    @FXML
    private TableColumn<Livreur, String> collabel;

    @FXML
    private TableColumn<Livreur, String> colprix;

    @FXML
    private TableView<mixed> table;

    @FXML
    private TextField tlabel;

    @FXML
    private TextField tprix;
    @FXML
    private TextField tqte;
    @FXML
    private TextField tidc;






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showlivreurs();
    }


    public  ObservableList<mixed> getDatamixed(){

        mixedDAO mix = null;

        ObservableList<mixed> listfcx = FXCollections.observableArrayList();

        mix = new mixedDAO();
        for (mixed ettemp : mix.getallm())
            listfcx.add(ettemp);

        return listfcx ;
    }
    public void showlivreurs(){
        ObservableList<mixed> list = getDatamixed();
        table.setItems(list);
        colidproduit.setCellValueFactory(new PropertyValueFactory<Livreur,String>("idproduit"));
        collabel.setCellValueFactory(new PropertyValueFactory<Livreur,String>("Label"));
        colprix.setCellValueFactory(new PropertyValueFactory<Livreur,String>("prix"));
        colqte.setCellValueFactory(new PropertyValueFactory<Livreur,String>("qte"));

    }
    @FXML
    void ajouterproduit(ActionEvent event) {

        mixed cmd=new mixed();
        cmd.setLabel(tlabel.getText());
        cmd.setPrix(Float.parseFloat(tprix.getText()));
        cmd.setQte(Integer.parseInt(tqte.getText()));
        cmd.setIdcommande(Integer.parseInt(tidc.getText()));

        mixedDAO cmdao = new mixedDAO();
        cmdao.savep(cmd);
        showlivreurs();
        clear();

    }



    @FXML
    void getData(MouseEvent event) {
        mixed cmd =table.getSelectionModel().getSelectedItem();
        idc = cmd.getIdproduit();

        tlabel.setText(cmd.getLabel());
        tprix.setText(String.valueOf(cmd.getPrix()));
        tqte.setText(String.valueOf(cmd.getQte()));
        tidc.setText(String.valueOf(cmd.getIdcommande()));


        btnajouter.setDisable(true);
    }

    @FXML
    void supprimerproduit(ActionEvent event) {
        mixedDAO liv=new mixedDAO();
        mixed cmd =table.getSelectionModel().getSelectedItem();
        idc = cmd.getIdproduit();
        liv.supprimerp(idc);

        showlivreurs();
        clear();

    }

    @FXML
    void modifierproduit(ActionEvent event) {
        mixed cmd= new mixed();
        mixedDAO dao = new mixedDAO();
        cmd.setLabel(tlabel.getText());
        cmd.setPrix(Float.parseFloat(tprix.getText()));
        cmd.setQte(Integer.parseInt(tqte.getText()));
        cmd.setIdcommande(Integer.parseInt(tidc.getText()));
        mixed check =table.getSelectionModel().getSelectedItem();
        idc = check.getIdproduit();
        dao.updatem(cmd,idc);


        showlivreurs();
        clear();


    }
    @FXML
    void cleartable(ActionEvent event){
        mixedDAO cmd = new mixedDAO();
        cmd.clear();
        showlivreurs();
        clear();
    }



    void clear(){
        tlabel.setText(null);
        tqte.setText(null);
        tprix.setText(null);
        tidc.setText(null);
        btnajouter.setDisable(false);
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
    void switchToTracking5(ActionEvent event) {
        Parent trackingParent = null;
        try {
            trackingParent = FXMLLoader.load(getClass().getResource("/Fxml/Produit.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene trackingScene = new Scene(trackingParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(trackingScene);
        window.show();
    }
}



