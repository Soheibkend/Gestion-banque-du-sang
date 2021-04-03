package sample.Classes;

public class DemandeSangAcc extends DemandeSang {

    private String dateAcc;

    public DemandeSangAcc(String numeroDemande, String demandeur, String nomDestinataire, String dateDemande, String grp, int nb, String rmq, String obj, String da) {
        super(numeroDemande, demandeur, demandeur, dateDemande, grp, nb, rmq, obj);
        dateAcc = da ;
    }

    public String getDateAcc() {
        return dateAcc;
    }

    public void setDateAcc(String dateAcc) {
        this.dateAcc = dateAcc;
    }

}
