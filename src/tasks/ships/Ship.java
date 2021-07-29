package tasks.ships;

import java.util.List;

public class Ship {
    static final Ship SHIP_FRUITS = new Ship(SizeShip.FRUITS, Product.FRUITS);
    static final Ship SHIP_CLOTHES = new Ship(SizeShip.CLOTHES, Product.CLOTHES);
    static final Ship SHIP_CARS = new Ship(SizeShip.CARS, Product.CARS);

    static List<Ship> listShip = List.of(SHIP_CARS, SHIP_CLOTHES, SHIP_FRUITS);

    private SizeShip sizeShip;
    private Product typeProduct;

    public Ship(SizeShip sizeShip, Product typeProduct) {
        this.sizeShip = sizeShip;
        this.typeProduct = typeProduct;
    }

    public Product getTypeProduct() {
        return typeProduct;
    }

    public SizeShip getSizeShip() {
        return sizeShip;
    }

    @Override
    public String toString() {
        return " {Корабль-" + typeProduct+"}" ;
    }
}
