package tasks.ships;

import java.util.List;

public class Ship {

    static final Ship shipFruits = new Ship(SizeShip.SHIP_FRUITS, Product.FRUITS);
    static final Ship shipClothes = new Ship(SizeShip.SHIP_CLOTHES, Product.CLOTHES);
    static final Ship shipCars = new Ship(SizeShip.SHIP_CARS, Product.CARS);

   static List<Ship> listShip= List.of(shipCars,shipClothes,shipFruits);

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
        return "Ship{" +
                "sizeShip=" + sizeShip.size +
                ", Product=" + typeProduct +
                '}';
    }
}
