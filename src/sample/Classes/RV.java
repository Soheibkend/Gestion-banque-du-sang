package sample.Classes;

public class RV {

    int numeroRV;
    String nomDonneur;
    String groupeSanguin;
    String date ;
    String hopital;

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

    public String getNomDonneur() {
        return nomDonneur;
    }

    public void setNomDonneur(String nomD) {
        this.nomDonneur = nomD;
    }

    public String getHopital() {
		return hopital;
	}

	public void setHopital(String hopital) {
		this.hopital = hopital;
	}

	public RV (int numeroRV, String nomDonneur, String groupeSanguin , String date, String hop) {
        this.numeroRV = numeroRV;
        this.nomDonneur = nomDonneur;
        this.groupeSanguin = groupeSanguin;
        this.date = date;
        this.hopital = hop;
    }


}
