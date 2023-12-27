package entities;

public class Utilisateurs {
    //Attribut
    private int id;
    private String email;
    private String password;
    private String passwordHashed;
    private String idRole;

    //constructors

    public Utilisateurs() {
    }

    public Utilisateurs(int id, String email, String password, String passwordHashed, String idRole) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.passwordHashed = passwordHashed;
        this.idRole = idRole;
    }

    //Getteurs

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordHashed() {
        return passwordHashed;
    }

    public String getIdRole() {
        return idRole;
    }
    //Setteurs

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordHashed(String passwordHashed) {
        this.passwordHashed = passwordHashed;
    }

    //Methodes
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password=" + passwordHashed +

                '}';
    }
}
