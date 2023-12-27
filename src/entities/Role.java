package entities;

public class Role {
    //Attribut
    private int id;
    private String name;

    //Constructors

    public Role() {
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getteurs

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Setteurs

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
