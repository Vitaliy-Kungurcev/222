package tasks.ships;

public enum SizeShip {
    FRUITS(100),
    CLOTHES(50),
    CARS(30);

    public int getSize() {
        return size;
    }

    private final int size;

    SizeShip(int size) {
        this.size = size;
    }
}
