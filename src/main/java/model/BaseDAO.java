package model;

import java.sql.*;
import java.util.List;

public abstract class BaseDAO {
   static   String user ="root";
    static String password = "";
   static   String url = "jdbc:mysql://localhost/glovo2";
   static   String driver = "com.mysql.cj.jdbc.Driver";
  public  Connection con =null;
   public  PreparedStatement st=null;
   public  ResultSet rs = null;
    public BaseDAO(){

        try {
            Class.forName(driver);
            try {
                con= DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

   public abstract void  save(Livreur object);
    public abstract void update(Livreur object,int id);
 public  abstract void supprimer(int id);
  public abstract void clear();
public  boolean login(Login object){
return true;
}

    public List<Livreur> getall() {

        return null;
    }
    public  List<Commande> getallc() {

        return null;
    }
    public  List<Produit> getallp() {

        return null;
    }
    public  List<mixed> getallm() {

        return null;
    }


}
