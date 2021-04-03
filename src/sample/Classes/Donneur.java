package sample.Classes;

public class Donneur {

    public String nom;
    public int age;
    public String adresse;
    public String contact;
    public String email;
    public String genre;
    public String groupeSanguin;
    public String remarque;

    public Donneur(String nom, int age, String adresse, String contact, String email, String genre, String groupeSanguin, String remarque) {
        this.nom = nom;
        this.age = age;
        this.adresse = adresse;
        this.contact = contact;
        this.email = email;
        this.genre = genre;
        this.groupeSanguin = groupeSanguin;
        this.remarque = remarque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
}
