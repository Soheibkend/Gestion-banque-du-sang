package sample.Classes;


public class DemandeSangRefus extends DemandeSang {

    private String dateRefus;

    public DemandeSangRefus(String numeroDemande, String demandeur, String nomDestinataire, String dateDemande, String grp , int nb, String rmq,String obj, String dr) {
        super(numeroDemande, demandeur, demandeur, dateDemande, grp, nb, rmq, obj);
        dateRefus = dr;
    }

    public String getDateRefus() {
        return dateRefus;
    }

    public void setDateRefus(String dateRefus) {
        this.dateRefus = dateRefus;
    }
}
