public class Dock implements Runnable {
    private Ship ship;
    private boolean busy = false;

    public Dock() {

    }

    public void setShip(Ship ship) {
        this.ship = ship;
        busy = true;
        System.out.println("Ship "+ship.getName()+" was docked");
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public synchronized void run() {
        int drawerCapacity = ship.getDrawerCapacity();
        for (int i = drawerCapacity; i > 0; i--) {
            try {
                System.out.println("one drawer was unloaded from : " + ship.getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
        }
        busy = false;
        notifyAll();
    }
}
