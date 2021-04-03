package sample.Classes;

public class demandeSang {

    String numeroDemande;
    String nomDemandeur;
    String nomDestinataire;
    String dateDemande;
    String groupeSanguin;
    int nombreSac;
    String Remarque;
    String objectif;

    public demandeSang(String numeroDemande, String nomDemandeur, String nomDestinataire, String dateDemande, String groupeSanguin, int nombreSac, String remarque, String objectif) {
        this.numeroDemande = numeroDemande;
        this.nomDemandeur = nomDemandeur;
        this.nomDestinataire = nomDestinataire;
        this.dateDemande = dateDemande;
        this.groupeSanguin = groupeSanguin;
        this.nombreSac = nombreSac;
        Remarque = remarque;
        this.objectif = objectif;
    }

    public String getNomDemandeur() {
        return nomDemandeur;
    }

    public void setNomDemandeur(String nomDemandeur) {
        this.nomDemandeur = nomDemandeur;
    }

    public String getNomDestinataire() {
        return nomDestinataire;
    }

    public void setNomDestinataire(String nomDestinataire) {
        this.nomDestinataire = nomDestinataire;
    }

    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public int getNombreSac() {
        return nombreSac;
    }

    public void setNombreSac(int nombreSac) {
        this.nombreSac = nombreSac;
    }

    public String getRemarque() {
        return Remarque;
    }

    public void setRemarque(String remarque) {
        Remarque = remarque;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }
}
