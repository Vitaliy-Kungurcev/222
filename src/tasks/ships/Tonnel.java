package tasks.ships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tonnel {
    volatile static List<Ship> tunnel = Collections.synchronizedList( new ArrayList<Ship>());
    private volatile int countShipInTunnel = 0;


    public synchronized void addShip() throws InterruptedException {
        while (countShipInTunnel >= 5) {
            System.out.println(Thread.currentThread().getName()+": Тоннель заполнен");
            wait();
        }
        Ship ship = Ship.listShip.get((int) (Math.random() * Ship.listShip.size()));
        tunnel.add(ship);
        countShipInTunnel++;
        System.out.println(Thread.currentThread().getName()+": В тоннель добавлен " + ship);

        Thread.sleep(3000);
        notifyAll();
    }

    public synchronized Ship giveTheShipFoLoading(Product product) throws InterruptedException {
        while (countShipInTunnel > 0) {
            for (Ship shipElement : tunnel) {
                if (shipElement.getTypeProduct() == product) {
                    tunnel.remove(shipElement);
                    notifyAll();
                    countShipInTunnel--;
                    System.out.println(Thread.currentThread().getName()+": Из тоннеля вызван: " + shipElement);
                    Thread.sleep(3000);
                    return shipElement;
                }
            }
            System.out.println(Thread.currentThread().getName()+": Кораблей для загрузки в тоннеле нет." +
                    "В тоннеле сейчас: " + tunnel.toString());
            wait();
        }
        return null;
    }
}





