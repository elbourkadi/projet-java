package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO  extends BaseDAO {
    int idc =0;
    public ProduitDAO(){
        super();
    }

    @Override
    public void save(Livreur object) {

    }

    @Override
    public void update(Livreur object, int id) {

    }


    public void  savep(Produit object){
        String request = "insert into Produits (Label ,Prix, idcommande) values (?,?,?)";

        // mapping objet table

        try {
            this.st = this.con.prepareStatement(request);
            this.st.setString(1 , object.getLabel());
            this.st.setFloat(2,object.getPrix());
            this.st.setInt(3 , object.getIdcommande());

            this.st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // mapping


    }

    public  void updatep(Produit object,int idproduit){
        String query ="update produits set Label = ?, Prix = ?, idcommande= ? where idProduit = ?";
        try {
            this.st = this.con.prepareStatement(query);
            this.st.setString(1 , object.getLabel());
            this.st.setFloat(2,object.getPrix());
            this.st.setInt(3 , object.getIdcommande());
            this.st.setInt(4, idproduit);
            this.st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void supprimer(int idcommande) {

    }
    public void supprimerp(int idproduit){
        String query = "Delete from produits where idproduit = ?";
        try {
            st=con.prepareStatement(query);

            st.setInt(1,idproduit);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public  List<Produit> getallp()  {

        List<Produit> mylist = new ArrayList<>();

        String request = "select * from produits ";

        try {
            st= con.prepareStatement(request);
            rs=st.executeQuery();

// parcours de la table
            while ( this.rs.next()){

// mapping table objet
                Produit li = new Produit();
                li.setLabel(rs.getString("Label"));
                li.setPrix(rs.getFloat("Prix"));
                li.setIdcommande(rs.getInt("idcommande"));
                li.setIdproduit(rs.getInt("idproduit"));

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
