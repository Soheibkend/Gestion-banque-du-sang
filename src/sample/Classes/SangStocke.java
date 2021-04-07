package sample.Classes;

import java.sql.Date;

public class SangStocke {

    int numeroSac;
    String groupeSanguin;
    String hopital;
    String dateCollect;

    public SangStocke(String groupeSanguin, int numeroSac, String dateCollect, String hopital) {
        this.groupeSanguin = groupeSanguin;
        this.numeroSac = numeroSac;
        this.dateCollect = dateCollect;
        this.hopital = hopital;
    }

    public int getNumeroSac() {
        return numeroSac;
    }

    public void setNumeroSac(int numeroSac) {
        this.numeroSac = numeroSac;
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


    public String getDateCollect() {
        return dateCollect;
    }

    public void setDateCollect(String dateCollect) {
        this.dateCollect = dateCollect;
    }
}
