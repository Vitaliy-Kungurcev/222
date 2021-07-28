package tasks.ships;

public enum SizeShip {
    SHIP_FRUITS(100),
    SHIP_CLOTHES(50),
    SHIP_CARS(30);


    public final int size;

    SizeShip(int size) {
        this.size = size;
    }
}
