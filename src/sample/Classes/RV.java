package sample.Classes;

public class RV {

    int numeroRV;
    int nombreSac;
    String groupeSanguin;
    String date ;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumeroRV() {
        return numeroRV;
    }

    public void setNumeroRV(int numeroRV) {
        this.numeroRV = numeroRV;
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

    public RV (int numeroRV, int nombreSac, String groupeSanguin , String date) {
        this.numeroRV = numeroRV;
        this.nombreSac = nombreSac;
        this.groupeSanguin = groupeSanguin;
        this.date = date;
    }


}
