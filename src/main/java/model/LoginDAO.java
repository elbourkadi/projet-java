package model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginDAO extends BaseDAO{


  public  LoginDAO(){
        super();
    }
@Override
public  boolean login(Login object){
    try {
        st=con.prepareStatement("select * from login  where username=? AND password=?");
        st.setString(1,object.getUsername());
        st.setString(2, object.getUsername());
        rs=st.executeQuery();
        if(rs.next()){

            return  true;
        }
        else{
            return false;
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


}


    @Override
    public void save(Livreur object) {

    }

    @Override
    public void update(Livreur object, int id) {

    }

    @Override
    public void supprimer(int id) {

    }

    @Override
    public void clear() {

    }

    @Override
    public List<Livreur> getall() {
        return null;
    }





}
