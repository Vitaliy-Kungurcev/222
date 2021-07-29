package tasks.ships;

import java.util.ArrayList;
import java.util.List;

public class Berth implements Runnable {
    private Product product;
    private Tonnel tonnel;
    private static volatile int countLoadShip;

    public Berth(Product product, Tonnel tonnel) {
        this.product = product;
        this.tonnel = tonnel;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName() + ": Запрос в тоннель на корабль");
                Ship ship = tonnel.giveTheShipFoLoading(this.product);

                System.out.println(Thread.currentThread().getName() + ": Начинается погрузка на корабль");
                Thread.sleep(ship.getSizeShip().getSize() * 200);

                System.out.println(Thread.currentThread().getName() + ": Погрузка закончена");
                synchronized (this) {
                    if (countLoadShip >= 3) {
                        Thread.currentThread().interrupt();
                        System.out.println("Попытка остановить поток " + Thread.currentThread().getName());
                    }
                   else {
                        countLoadShip++;
                        System.out.println("В списке загруженных- " + countLoadShip + " кораблей");
                        System.out.println(Thread.currentThread().getName() + ": Причал готов к работе.");
                        Thread.sleep(3000);
                    }
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Поток " + Thread.currentThread().getName() + " остановлен");
    }
}
