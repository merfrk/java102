package PatikaStore;

public class Marka implements Comparable<Marka> {
    private int ID;
    private String name;

    public Marka(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public int compareTo(Marka o) {
        return name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
