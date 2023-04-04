package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreurDAO extends BaseDAO {
    int id =0;
    public LivreurDAO(){
        super();
    }
    public void  save(Livreur object){
         String request = "insert into livreurs (Nom ,Prenom, Telephone) values (?,?, ?)";

         // mapping objet table

         try {
             this.st = this.con.prepareStatement(request);
             this.st.setString(1 , object.getNom());
             this.st.setString(2,object.getNom());
             this.st.setString(3 , object.getTelephone());
             this.st.execute();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         // mapping


     }

   public  void update(Livreur object,int id){
         String query ="update livreurs set Nom = ?, Prenom = ?, Telephone= ? where id = ?";
         try {
             this.st = this.con.prepareStatement(query);
             this.st.setString(1 , object.getNom());
             this.st.setString(2,object.getPrenom());
             this.st.setString(3 , object.getTelephone());
             this.st.setInt(4, id);
             this.st.executeUpdate();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

     }
    public void supprimer(int id) {
        String query = "Delete from livreurs where id = ?";
        try {
            st=con.prepareStatement(query);

            st.setInt(1,id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Livreur> getall()  {

        List<Livreur> mylist = new ArrayList<Livreur>();

        String request = "select * from livreurs ";

        try {
           st= con.prepareStatement(request);
           rs=st.executeQuery();

// parcours de la table
            while ( this.rs.next()){

// mapping table objet
                Livreur li = new Livreur();
                li.setNom(rs.getString("Nom"));
                li.setPrenom(rs.getString("Prenom"));
                li.setTelephone(rs.getString("Telephone"));
                li.setId(rs.getInt("Id"));

                mylist.add(li);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




        return mylist;
    }

  public  void clear() {
        String query ="Delete  from livreurs ";

        try {
            st=con.prepareStatement(query);


            st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
