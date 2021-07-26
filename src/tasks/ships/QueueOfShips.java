package tasks.ships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueueOfShips extends Thread {
    static volatile List<Ship> tunnel = Collections.synchronizedList(new ArrayList<Ship>());


    @Override
    public void run() {
        while (true) {
            addShip();
        }
    }

    public void addShip() {
        Ship ship = Ship.listShip.get((int) (Math.random() * Ship.listShip.size()));
        if (tunnel.size() < 5) {
            tunnel.add(ship);
            System.out.println("В тоннель добавлен случайный " + ship);

        }
    }

    public Ship giveTheShipFoLoading(Product product) {
        for (Ship ship : tunnel) {
            if (ship.getTypeProduct() == product) {
                return ship;
            }
        }
        return null;
    }

    public List<Ship> getTunnel() {
        return tunnel;
    }


}
