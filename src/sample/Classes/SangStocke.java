package sample.Classes;

public class SangStocke {

    String groupeSanguin;
    int nombreSac;
    String dateCollect;

    public SangStocke(String groupeSanguin, int nombreSac, String dateCollect) {
        this.groupeSanguin = groupeSanguin;
        this.nombreSac = nombreSac;
        this.dateCollect = dateCollect;
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

    public String getDateCollect() {
        return dateCollect;
    }

    public void setDateCollect(String dateCollect) {
        this.dateCollect = dateCollect;
    }
}
