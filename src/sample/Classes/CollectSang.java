package sample.Classes;

import java.util.Date;

public class CollectSang {

    String nomDonateur;
    String hopital;
    String groupeSanguin;
    String nomMedecin;
    String dateCollection;

    public CollectSang(String nomDonateur, String hopital, String groupeSanguin, String nomMedecin, String dateCollection) {
        this.nomDonateur = nomDonateur;
        this.hopital = hopital;
        this.groupeSanguin = groupeSanguin;
        this.nomMedecin = nomMedecin;
        this.dateCollection = dateCollection;
    }

    public String getNomDonateur() {
        return nomDonateur;
    }

    public void setNomDonateur(String nomDonateur) {
        this.nomDonateur = nomDonateur;
    }

    public String getHopital() {
        return hopital;
    }

    public void setHopital(String hopital) {
        this.hopital = hopital;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getDateCollection() {
        return dateCollection;
    }

    public void setDateCollection(String dateCollection) {
        this.dateCollection = dateCollection;
    }
}
