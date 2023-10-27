public class Main {
    public static void main(String[] args) {
        SeaPort seaPort = new SeaPort(2);
        Ship ship1 = new Ship("Anna Maria",10);
        Ship ship2 = new Ship("Papa Carlo",10);
        Ship ship3 = new Ship("Mars",10);
        seaPort.addShipToQueue(ship1);
        seaPort.addShipToQueue(ship2);
        seaPort.addShipToQueue(ship3);
        seaPort.unloadShips();
    }
}
