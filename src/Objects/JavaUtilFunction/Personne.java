package Objects.JavaUtilFunction;

public class Personne {
    private String nom;
    private int age;

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

    public Personne(int age, String nom) {
        this.age = age;
        this.nom = nom;
    }

    public String toString() {return "#Nom : " + getNom() + " - âge : " + getAge();}
}
