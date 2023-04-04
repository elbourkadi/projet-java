package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mixedDAO extends BaseDAO {
    @Override
    public void save(Livreur object) {

    }

    @Override
    public void update(Livreur object, int id) {

    }

    @Override
    public void supprimer(int id) {

    }
    public void supprimerp(int idproduit){
        String query = "Delete from mixed where idproduit_commande = ?";
        try {
            st=con.prepareStatement(query);

            st.setInt(1,idproduit);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static int count=0;
    static List<Integer> counter =new ArrayList<>();
    public void setCount(int count){
        counter.add(count);
    }

    @Override
    public void clear() {

    }
    
    @Override
    public  List<mixed> getallm()  {
int lastElement = 0;
        List<mixed> mylist = new ArrayList<>();

        String request = "SELECT * FROM mixed  where idcommande =?";

        try {
            Iterator<Integer> it = counter.iterator();
            st= con.prepareStatement(request);

            while (it.hasNext()) {
                lastElement = it.next();
            }
            this.st.setInt(1 ,lastElement);

            rs=st.executeQuery();

// parcours de la table
            while ( this.rs.next()){

// mapping table objet
                mixed li = new mixed();
                li.setLabel(rs.getString("Label"));
                li.setPrix(rs.getFloat("Prix"));
                li.setIdproduit(rs.getInt("idproduit_commande"));
                li.setQte(rs.getInt("qte"));
                li.setIdcommande(rs.getInt("idcommande"));

                mylist.add(li);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




        return mylist;
    }
    public void  savep(mixed object){
        String request = "insert into mixed (Label ,Prix,qte,idcommande) values (?,?,?,?)";

        // mapping objet table

        try {
            this.st = this.con.prepareStatement(request);
            this.st.setString(1 , object.getLabel());
            this.st.setFloat(2,object.getPrix());
            this.st.setInt(3,object.getQte());
            this.st.setInt(4,object.getIdcommande());


            this.st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // mapping


    }
    public  void updatem(mixed object,int idproduit){
        String query ="update mixed set Label = ?, Prix = ?, idcommande= ?,qte=? where idproduit_commande = ?";
        try {
            this.st = this.con.prepareStatement(query);
            this.st.setString(1 , object.getLabel());
            this.st.setFloat(2,object.getPrix());
            this.st.setInt(3 , object.getIdcommande());
            this.st.setInt(4, object.getQte());
            this.st.setInt(5,idproduit);
            this.st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
