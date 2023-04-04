package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO  extends BaseDAO {
    int idc =0;
    public CommandeDAO(){
        super();
    }

    @Override
    public void save(Livreur object) {

    }

    @Override
    public void update(Livreur object, int id) {

    }


    public void  savec(Commande object){
        String request = "INSERT INTO  commandes (id,Adresse ,date_debut, date_fin) values (?,?, ?,?)";

        // mapping objet table

        try {
            this.st = this.con.prepareStatement(request);
            this.st.setInt(1,object.getId());
            this.st.setString(2 , object.getAdresse());
            this.st.setString(3,object.getDate_debut());
            this.st.setString(4 , object.getDate_fin());

            this.st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // mapping


    }

    public  void updatec(Commande object,int idcommande){
        String query =" UPDATE commandes set Adresse = ?, date_debut = ?, date_fin= ? where id_commande = ?";
        try {
            this.st = this.con.prepareStatement(query);
            this.st.setString(1 , object.getAdresse());
            this.st.setString(2,object.getDate_debut());
            this.st.setString(3 , object.getDate_fin());
            this.st.setInt(4, idcommande);
            this.st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void supprimer(int idcommande) {

    }
    public void supprimerc(int idcommande){
        String query = "Delete from commandes where id_commande = ?";
        try {
            st=con.prepareStatement(query);

            st.setInt(1,idcommande);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public  List<Commande> getallc()  {

        List<Commande> mylist = new ArrayList<>();

        String request = "select * from commandes ";

        try {
            st= con.prepareStatement(request);
            rs=st.executeQuery();

// parcours de la table
            while ( this.rs.next()){

// mapping table objet
                Commande li = new Commande();
                li.setAdresse(rs.getString("Adresse"));
                li.setDate_debut(rs.getString("date_debut"));
                li.setDate_fin(rs.getString("date_fin"));
                li.setIdcommande(rs.getInt("Id_commande"));
                li.setId(rs.getInt("id"));
                mylist.add(li);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




        return mylist;
    }

    public  void clear() {
        String query ="Delete  from commandes ";

        try {
            st=con.prepareStatement(query);


            st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
