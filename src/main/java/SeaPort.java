import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SeaPort {
    private Dock[] docks;
    public Thread[] unloadThreads;
    ConcurrentLinkedQueue<Ship> ships = new ConcurrentLinkedQueue<>();

    public SeaPort(int quantityDocks) {
        this.docks = new Dock[quantityDocks];
        this.unloadThreads = new Thread[quantityDocks];
        for (int i = 0; i < quantityDocks; i++) {
            docks[i] = new Dock();
        }
    }

    public void addShipToQueue(Ship ship) {
        ships.add(ship);
    }

    public synchronized void unloadShips() {
        int freeDockPosition;
        while (!ships.isEmpty()) {
            freeDockPosition = getFreeDock();
            if (freeDockPosition>=0){
                docks[freeDockPosition].setShip(ships.poll());
                unloadThreads[freeDockPosition] = new Thread(docks[freeDockPosition]);
                unloadThreads[freeDockPosition].start();
            }
        }
        System.out.println("There aren't ships in queue");
    }

    public int getFreeDock() {
        int result = -1;
        for (int i = 0; i < docks.length; i++) {
            if (!docks[i].isBusy()) return i;
        }
        return result;
    }
}
