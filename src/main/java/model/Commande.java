package model;

public class Commande {
    protected int idcommande;
    protected   String Adresse;
    protected int id ;
    protected String date_debut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String date_fin;



    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }



    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }
}
