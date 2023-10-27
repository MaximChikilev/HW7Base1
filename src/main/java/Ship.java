public class Ship {
    private String name;
    private int drawerCapacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawerCapacity() {
        return drawerCapacity;
    }

    public void setDrawerCapacity(int drawerCapacity) {
        this.drawerCapacity = drawerCapacity;
    }

    public Ship(String name, int drawerCapacity) {
        this.name = name;
        this.drawerCapacity = drawerCapacity;
    }
}
